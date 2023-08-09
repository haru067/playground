package com.haru067.playground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun VerificationCodeInputExample(
    modifier: Modifier = Modifier,
) {
    val (sampleText, setSampleText) = remember { mutableStateOf(TextFieldValue(text = "123")) }

    Column(modifier) {
        VerificationCodeInput(
            value = sampleText,
            onValueChange = setSampleText,
        )
    }
}

@Composable
private fun VerificationCodeInput(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    digit: Int = 6,
) {
    BasicTextField(
        value = value,
        modifier = modifier,
        onValueChange = {
            val text = if (it.text.length <= digit) it.text.filter { c -> c.isDigit() } else value.text
            onValueChange(it.copy(text = text))
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        interactionSource = interactionSource,
        decorationBox = @Composable { _ ->
            Row {
                value.text.padEnd(length = digit, padChar = ' ').forEachIndexed { index, char ->
                    SingleNumberBox(
                        numberChar = char,
                        selected = value.selection.contains(index),
                        focused = value.selection.start == value.selection.end && value.selection.start == index,
                        modifier = Modifier
                            .clickable {
                                onValueChange(value.copy(selection = TextRange(start = index, end = index)))
                            }
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }
        },
    )
}

@Composable
internal fun SingleNumberBox(
    modifier: Modifier = Modifier,
    numberChar: Char,
    selected: Boolean,
    focused: Boolean,
) {
    val backgroundColor = when {
        focused -> MaterialTheme.colorScheme.secondaryContainer
        selected -> MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
        else -> MaterialTheme.colorScheme.primary
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(8.dp)
    ) {
        Text(
            text = numberChar.toString(),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )
    }
}
