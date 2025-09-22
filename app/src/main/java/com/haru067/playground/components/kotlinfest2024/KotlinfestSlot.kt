package com.haru067.playground.components.kotlinfest2024

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.haru067.playground.R

@Composable
private fun AppBarUsage(modifier: Modifier = Modifier) {
  AppBar(
    title = { Text("") },
    navigationIcon = { IconButton(onClick = {}) {} },
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
  TopAppBar(title = { /*TODO*/ })
}

@Composable
private fun SimplicityComparison() {
  Button(
    content = { Text("Button text") },
    onClick = { /* ... */ },
  )

  Button(
    // content = "Direct text",
    onClick = { /* ... */ },
  )
}

@Composable
fun AppBar(
  title: @Composable () -> Unit,
  navigationIcon: @Composable () -> Unit,
) {

}

@Composable
fun DslAppBar(
  title: @Composable () -> Unit,
  navigationIcon: @Composable AppBarIconScope.() -> Unit,
) {

}

@Stable
class AppBarIconScope {
  @Composable
  fun BackButton(back: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = back, modifier = modifier) {
      Icon(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = null,
      )
    }
  }
}

@Composable
private fun DslAppBarUsage(modifier: Modifier = Modifier) {
  // Example usage
  DslAppBar(
    title = { Text("Title") },
    navigationIcon = {
      BackButton(back = { /* ... */ })
    },
  )
}
@Composable
private fun AppBar2(modifier: Modifier = Modifier) {

}
