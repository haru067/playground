package com.haru067.playground.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldExample(
    modifier: Modifier = Modifier,
) {
    val (sampleText, setSampleText) = remember { mutableStateOf("M3 TextField") }
    val (sampleText2, setSampleText2) = remember { mutableStateOf("Custom TextField") }
    Row(modifier) {
        TextField(
            value = sampleText,
            onValueChange = setSampleText,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
        )

        CustomTextField(
            value = sampleText2,
            onValueChange = setSampleText2,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
        )
    }
}

@Composable
private fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = LocalTextStyle.current,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val focused by interactionSource.collectIsFocusedAsState()
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = textStyle.copy(color = MaterialTheme.colorScheme.onSurface),
        interactionSource = interactionSource,
        modifier = modifier,
        decorationBox = @Composable { innerTextField ->
            CustomDecorationBox(
                focused = focused,
                innerTextField = innerTextField,
            )
        },
    )
}

@Composable
private fun CustomDecorationBox(
    modifier: Modifier = Modifier,
    focused: Boolean,
    innerTextField: @Composable () -> Unit,
) {
    Box(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(56.dp)
                .align(Alignment.CenterStart),
        ) {
            innerTextField()
        }
        Divider(
            thickness = if (focused) 2.dp else 1.dp,
            color = if (focused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}
