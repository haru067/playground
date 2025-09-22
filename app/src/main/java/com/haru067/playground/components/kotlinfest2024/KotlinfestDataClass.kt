package com.haru067.playground.components.kotlinfest2024

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class House(
  val name: String,
  val address: String,
  val imageUrl: String,
)

data class HouseUiState(
  val name: String,
  val address: String,
  val imageUrl: String,
)

@Composable
fun HouseHeader(
  house: House,
) {

}

@Composable
fun HouseHeader(
  name: String,
  placeName: String,
) {

}

@Composable
fun HouseHeader(
  house: HouseUiState,
) {

}

@Composable
fun HouseHeader(
  name: String,
  placeName: String,
  imageUrl: String,
  address: String,
) {

}

@Preview
@Composable
fun PreviewHouseHeader() {
  HouseHeader(
    House(
      name = "IRORI",
      address = "Address",
      imageUrl = "",
    )
  )
}
