package com.chaesung.test_app

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.chaesung.androidhub.ui.MainActivity
import com.chaesung.data.di.fakeHubModels
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AppTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test1() {
        // TODO: Add navigation tests
        composeTestRule.onNodeWithText(fakeHubModels.first(), substring = true).assertExists()
    }
}
