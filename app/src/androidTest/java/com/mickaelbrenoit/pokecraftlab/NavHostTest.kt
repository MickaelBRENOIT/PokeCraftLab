package com.mickaelbrenoit.pokecraftlab

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavHostTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * References:
     * - https://developer.android.com/training/dependency-injection/hilt-testing?hl=fr
     * - https://developer.android.com/jetpack/compose/navigation?hl=fr#testing
     * - https://stackoverflow.com/questions/75644786/jetpack-compose-how-to-test-navigation
     */

    @Test
    fun TestNavigationToDestination() {

        val context: Context = ApplicationProvider.getApplicationContext()

        composeTestRule.activity.setContent {
            TestNavHost()
        }

        // Assert that the destination screen is displayed
        composeTestRule.onNodeWithText("Signin").assertIsDisplayed()
    }
}