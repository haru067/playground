package com.haru067.playground.components.strongskipping

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun StrongSkippingExample(
  modifier: Modifier = Modifier,
) {
  val viewModel = viewModel<StrongSkippingViewModel>()
  val uiState by viewModel.uiState.collectAsState()
  // val uiState2 by viewModel.uiState2.collectAsState()

  Column(modifier) {
    UserList(uiState.userNames, Modifier.fillMaxWidth())
    Text("Some data: ${uiState.someData}", modifier.padding(16.dp))

    // UserList(uiState2.userNames, Modifier.fillMaxWidth())
    // Text("Some data: ${uiState2.someData}", modifier.padding(16.dp))
  }
}

@Composable
internal fun UserList(
  userNames: List<String>,
  modifier: Modifier = Modifier,
) {
  Column(modifier) {
    userNames.forEach { userName ->
      Text(text = userName, modifier = Modifier.padding(16.dp))
    }
  }
}

@Preview
@Composable
private fun PreviewStrongSkippingExample() {
  MaterialTheme {
    StrongSkippingExample()
  }
}
