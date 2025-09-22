package com.haru067.playground.components.kotlinfest2024

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SomeComponent() {
  Button(onClick = {}) { /*...*/ }
}

@Composable
fun Button(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  shape: Shape = ButtonDefaults.shape,
  colors: ButtonColors = ButtonDefaults.buttonColors(),
  elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
  // ...
)
// ...
{
  androidx.compose.material3.Button(onClick = { /*TODO*/ }) {

  }
}

object ButtonDefaults {
  val shape: Shape @Composable get() = ButtonDefaults.shape

  @Composable
  fun buttonColors(): ButtonColors = ButtonDefaults.buttonColors()

  @Composable
  fun buttonElevation(): ButtonElevation = ButtonDefaults.buttonElevation()
}


@Composable
fun CenteredText(modifier: Modifier = Modifier) {
  Column(modifier) {
    Text(
      text = "中央揃えしたい文字列",
      modifier = Modifier
          .align(Alignment.CenterHorizontally)
          .padding(32.dp)
    )
  }
}

@Composable
private fun GoodDefaultParameterExample2(modifier: Modifier = Modifier) {
  Column(modifier) {
    Text(
      text = "中央揃えしたい文字列",
      textAlign = TextAlign.Center,
      modifier = Modifier
          .align(Alignment.CenterHorizontally)
          .padding(32.dp)
    )
  }
}

@Preview
@Composable
private fun PreviewCenteredText() {
  Column {
    CenteredText()
  }
}

@Preview
@Composable
private fun PreviewDefaultParameterExample2() {
  Column {
    CenteredText(Modifier.width(170.dp))
  }
}

@Preview
@Composable
private fun PreviewDefaultParameterExample3() {
  Column {
    GoodDefaultParameterExample2(Modifier.width(170.dp))
  }
}
