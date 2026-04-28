package com.example.android_studio_test_exercice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Regla que obre la MainActivity per poder testejar la UI real
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Comprova que el Switch del Wi-Fi existeix i es mostra a la pantalla
    @Test
    fun checkWifiSwitchExists() {
        composeTestRule
            .onNodeWithTag("wifiSwitch_id")
            .assertIsDisplayed()
    }

    // Comprova que els checkboxes existeixen i es mostren correctament
    @Test
    fun checkCheckboxesExist() {
        composeTestRule
            .onNodeWithTag("carnivorCheckbox_id")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("vegetariaCheckbox_id")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("vegaCheckbox_id")
            .assertIsDisplayed()
    }
}