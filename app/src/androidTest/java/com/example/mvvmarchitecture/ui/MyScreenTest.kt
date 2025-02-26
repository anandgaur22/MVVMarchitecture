package com.example.mvvmarchitecture.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.mvvmarchitecture.model.MyData
import com.example.mvvmarchitecture.ui.theme.MVVMarchitectureTheme
import org.junit.Rule
import org.junit.Test

class MyScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myScreen_displaysLoadingState() {
        // Given
        composeTestRule.setContent {
            MVVMarchitectureTheme {
                MyScreen()
            }
        }

        // Then
        composeTestRule.onNodeWithTag("loading_indicator").assertExists()
    }

    @Test
    fun myScreen_displaysData() {
        // Given
        val testData = MyData(1, 1, "Test Task", false)
        
        composeTestRule.setContent {
            MVVMarchitectureTheme {
                MyItemCard(item = testData)
            }
        }

        // Then
        composeTestRule.onNodeWithText("Test Task").assertExists()
        composeTestRule.onNodeWithText("User ID: 1 - Task ID: 1").assertExists()
    }
} 