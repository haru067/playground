package com.haru067.playground.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.haru067.playground.databinding.FragmentContainerBinding

@Composable
fun FragmentExample(modifier: Modifier = Modifier) {
    AndroidViewBinding(
        factory = { inflater, parent, attachToParent ->
            FragmentContainerBinding.inflate(inflater, parent, attachToParent)
        },
        modifier = modifier,
        onReset = {
        },
        onRelease = {
        },
        update = {
        },
    )
}
