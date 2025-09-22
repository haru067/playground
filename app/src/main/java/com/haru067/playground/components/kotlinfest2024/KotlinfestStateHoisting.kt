package com.haru067.playground.components.kotlinfest2024

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ParentComponent() {
  var expanded by remember { mutableStateOf(false) }
  Accordion(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded }
  )
}

@Composable
fun HoistAccordion(
  expanded: Boolean,
  onExpandedChange: () -> Unit,
) {
  Column {
    Text(
      text = "Click to expand",
      modifier = Modifier.clickable { onExpandedChange() }
    )
    AnimatedVisibility(visible = expanded) { Text("Expanded content") }
  }
}

@Composable
fun OriginalParentComponent() {
  AccordionStateful()
}

@Composable
fun OriginalAccordion() {
  var expanded by remember { mutableStateOf(false) }

  Column {
    Text(
      text = "Click to expand",
      modifier = Modifier.clickable { expanded = !expanded },
    )
    AnimatedVisibility(visible = expanded) { Text("Expanded content") }
  }
}

@Preview
@Composable
private fun PreviewCollapsed() {
  HoistAccordion(expanded = false, onExpandedChange = {})
}

@Preview
@Composable
private fun PreviewExpanded() {
  HoistAccordion(expanded = true, onExpandedChange = {})
}

