package com.haru067.playground.components.kotlinfest2024

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Button(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  content: @Composable RowScope.() -> Unit,
) {
  // ...
}

@Composable
private fun AppBarText(modifier: Modifier = Modifier) {
}
