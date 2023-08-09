package com.haru067.playground.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowExample(
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Row1(text = "text", modifier = Modifier.fillMaxWidth())
        Row2(text = "text", modifier = Modifier.fillMaxWidth())
        Row3(text = "text", modifier = Modifier.fillMaxWidth())

        Divider(Modifier.padding(vertical = 16.dp))

        Row1(text = "text".repeat(16), modifier = Modifier.fillMaxWidth())
        Row2(text = "text".repeat(16), modifier = Modifier.fillMaxWidth())
        Row3(text = "text".repeat(16), modifier = Modifier.fillMaxWidth())

        Divider(Modifier.padding(vertical = 16.dp))

        Row3(text = "fill = true", modifier = Modifier.fillMaxWidth())
        Row4(text = "fill = false", modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun Row1(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Text(
            text = text,
            modifier = Modifier.border(1.dp, Color.Blue)
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "icon",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
private fun Row2(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {
        Text(
            text = text,
            modifier = Modifier.border(1.dp, Color.Blue)
        )
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "icon",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
private fun Row3(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Blue),
        )
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "icon",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
private fun Row4(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f, fill = false)
                .border(1.dp, Color.Blue),
        )
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "icon",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewRowExample() {
    RowExample(
        Modifier.width(200.dp)
    )
}
