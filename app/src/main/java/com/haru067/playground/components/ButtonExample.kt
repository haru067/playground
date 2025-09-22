package com.haru067.playground.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haru067.playground.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonExample(modifier: Modifier = Modifier) {
  Row(modifier) {
    Button(
      onClick = {},
      modifier = Modifier
        .border(width = 1.dp, color = Color.Blue)
    ) {
      Text("Default")
    }
    Spacer(modifier = Modifier.width(16.dp))
    Button(
      onClick = {},
      modifier = Modifier
        .border(width = 1.dp, color = Color.Blue)
        .heightIn(min = 36.dp)
    ) {
      Text("36dp")
      Text(stringResource(R.string.test_tex))
    }
    Spacer(modifier = Modifier.width(16.dp))

    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
      Button(
        onClick = {},
        modifier = Modifier
          .border(width = 1.dp, color = Color.Blue)
          .heightIn(min = 36.dp)
      ) {
        Text("36.dp")
      }
    }
  }
}

@Preview
@Composable
private fun PreviewButton() {
  ButtonExample()
}
