package com.haru067.playground.components.kotlinfest2024

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TooLongProperties(
  mealSectionTitle: String,
  mealSectionSubtitle: String,
  scheduleSectionTitle: String,
  scheduleSectionSubtitle: String,
  meals: List<Meal>,
  schedule: Schedule,
) {

}

@Composable
fun ShortProperties(
  mealSectionUiState: MealSectionUiState,
  scheduleSectionUiState: ScheduleSectionUiState,
) {

}

data class MealSectionUiState(val hoge: String)
data class ScheduleSectionUiState(val hoge: String)
data class Meal(val hoge: String)
data class Schedule(val hoge: String)
