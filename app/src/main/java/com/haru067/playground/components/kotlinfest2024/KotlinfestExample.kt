package com.haru067.playground.components.kotlinfest2024

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class User(
  val name: String,
  val email: String,
)

@Composable
private fun UserProfile(
  user: User,
  modifier: Modifier = Modifier,
) {
}

@Composable
private fun UserProfile(
  name: String,
  email: String,
  modifier: Modifier = Modifier,
) {
}

@Composable
fun ParentComponent(modifier: Modifier = Modifier) {
  AccordionStateful()

  var expanded by remember { mutableStateOf(false) }
  Accordion(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded }
  )
}

@Composable
fun Accordion(
  expanded: Boolean,
  onExpandedChange: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(modifier) {
    Text(text = "Click to expand", Modifier.clickable { onExpandedChange() })
    AnimatedVisibility(visible = expanded) {
      Text(text = "expanded content")
    }
  }
}

@Composable
fun AccordionStateful(
  modifier: Modifier = Modifier,
) {
  var expanded by remember { mutableStateOf(false) }

  Column(modifier) {
    Text(
      text = "Click to expand",
      modifier = Modifier.clickable { expanded = !expanded },
    )
    AnimatedVisibility(visible = expanded) {
      Text("expanded content")
    }
  }
}

@Composable
fun AccordionOverload(
  modifier: Modifier = Modifier,
) {
  var expanded by remember { mutableStateOf(false) }

  Accordion(expanded = expanded, onExpandedChange = { expanded = !expanded })
}

@Preview
@Composable
private fun PreviewExpanded() {
  Accordion(expanded = true, onExpandedChange = {})
}

@Preview
@Composable
private fun PreviewCollapsed() {
  Accordion(expanded = false, onExpandedChange = {})
}

@Preview
@Composable
private fun PreviewStateful() {
  AccordionStateful()
}

@Preview
@Composable
private fun PreviewOverload() {
  AccordionOverload()
}
