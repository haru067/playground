package com.haru067.playground

import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testToday() {
        composeTestRule.setContent {
            Text(text = "Hello World!")
        }
        composeTestRule.onNodeWithText("Hello World!").assertExists()
    }
}
