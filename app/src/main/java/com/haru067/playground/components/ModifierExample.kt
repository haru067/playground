package com.haru067.playground.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun IndicationExample(
  modifier: Modifier = Modifier,
) {
  val interactionSource = remember { MutableInteractionSource() }
  var selected by remember { mutableStateOf(false) }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(4.dp),
    modifier = modifier
      .clickable(
        onClick = { selected = !selected },
        indication = null,
        interactionSource = interactionSource,
      )
  ) {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
          .clip(RoundedCornerShape(4.dp))
          .background(Color.LightGray)
          .indication(indication = LocalIndication.current, interactionSource = interactionSource)
          .size(96.dp)
          .border(
              width = 2.dp,
              color = if (selected) MaterialTheme.colorScheme.primary else Color.Transparent,
              shape = RoundedCornerShape(4.dp),
          ),
    ) {
      Text("画像")
    }
    Text(
      text = "タイトル",
      textAlign = TextAlign.Center,
    )
  }
}

@Preview
@Composable
private fun PreviewModifierExample() {
  MaterialTheme {
    IndicationExample(
      Modifier
          .background(MaterialTheme.colorScheme.background)
          .padding(16.dp)
    )
  }
}
