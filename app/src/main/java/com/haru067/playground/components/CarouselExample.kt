package com.haru067.playground.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private const val PAGE_COUNT = Int.MAX_VALUE
private const val INITIAL_PAGE = PAGE_COUNT / 2
private val pageColors = listOf(
    Color.Red,
    Color.Green,
    Color.Blue,
)

private fun getActualPage(page: Int, actualPageCount: Int): Int {
    val diff = (page - INITIAL_PAGE) % actualPageCount
    return if (diff < 0) actualPageCount + diff else diff
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselExample(modifier: Modifier = Modifier) {
    Box(modifier) {
        val pagerState = rememberPagerState(initialPage = INITIAL_PAGE)
        val actualPageCount = pageColors.size
        HorizontalPager(
            state = pagerState,
            pageCount = if (actualPageCount > 0) PAGE_COUNT else 0,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            val actualPage = getActualPage(page = page, actualPageCount = actualPageCount)
            val color = pageColors[actualPage]

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(color)
                    .fillMaxSize()
            ) {
                Text("Page $actualPage")
            }
        }
        if (actualPageCount > 0) {
            val actualSettledPage = getActualPage(page = pagerState.settledPage, actualPageCount = actualPageCount)
            HorizontalPagerIndicator(
                currentPage = actualSettledPage,
                pageCount = actualPageCount,
                scrollToPage = { actualNextPage ->
                    val distance = actualNextPage - actualSettledPage
                    pagerState.animateScrollToPage(pagerState.settledPage + distance)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
            )
        }
    }
}

@Composable
fun HorizontalPagerIndicator(
    modifier: Modifier = Modifier,
    currentPage: Int,
    pageCount: Int,
    scrollToPage: suspend (Int) -> Unit,
) {
    Row(modifier) {
        for (page in 0 until pageCount) {
            IndicatorItem(
                animate = page == currentPage,
                onAnimationFinished = { scrollToPage(page + 1) },
                onClick = { scrollToPage(page) },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
            )
        }
    }
}

@Composable
private fun IndicatorItem(
    progress: Float?,
    onClick: suspend () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    Box(modifier.clickable { scope.launch { onClick() } }) {
        // Indicator line
        Box(
            Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.White.copy(alpha = 0.5f))
        )
        if (progress != null) {
            // Progress line
            Box(
                Modifier
                    .fillMaxWidth(progress)
                    .height(4.dp)
                    .background(Color.White)
            )
        }
    }
}

@Composable
private fun IndicatorItem(
    animate: Boolean,
    onAnimationFinished: suspend () -> Unit,
    onClick: suspend () -> Unit,
    modifier: Modifier = Modifier,
) {
    val progress = remember { Animatable(0f) }
    LaunchedEffect(animate) {
        if (animate) {
            val result = progress.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 5000, easing = LinearEasing),
            )
            if (result.endReason == AnimationEndReason.Finished) {
                onAnimationFinished()
            }
        } else {
            progress.snapTo(0f)
        }
    }
    IndicatorItem(
        progress = progress.value,
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun PreviewCarouselExample() {
    CarouselExample()
}
