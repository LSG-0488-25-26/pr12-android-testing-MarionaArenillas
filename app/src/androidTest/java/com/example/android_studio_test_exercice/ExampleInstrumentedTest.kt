package com.example.android_studio_test_exercice

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
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

    // Comprova que el TriStateCheckbox existeix i es mostra correctament
    @Test
    fun checkTriStateCheckboxExists() {
        composeTestRule
            .onNodeWithTag("triStateCheckbox_id")
            .assertIsDisplayed()
    }

    // Comprova que els RadioButtons existeixen i es mostren correctament
    @Test
    fun checkRadioButtonsExist() {
        composeTestRule
            .onNodeWithTag("Vinicius_radio_id")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("LamineYamal_radio_id")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("Raphina_radio_id")
            .assertIsDisplayed()
    }

    // Comprova que el Slider existeix i es mostra correctament
    @Test
    fun checkSliderExists() {
        composeTestRule
            .onNodeWithTag("slider_id")
            .assertIsDisplayed()
    }

    // Comprova que el text del DropdownMenu existeix i es mostra
    @Test
    fun checkDropdownTextExists() {
        composeTestRule
            .onNodeWithTag("dropdownText_id")
            .assertIsDisplayed()
    }

    // Comprova que el camp de cerca permet escriure text
    @Test
    fun checkSearchTextField() {
        composeTestRule
            .onNodeWithTag("searchTextField_id")
            .performTextInput("prova")

        composeTestRule
            .onNodeWithTag("searchTextField_id")
            .assertTextContains("prova")
    }

    // Comprova que en prémer el botó Buscar
    // apareix el missatge de confirmació
    @Test
    fun checkSearchButton() {
        composeTestRule
            .onNodeWithTag("searchButton_id")
            .performClick()

        composeTestRule
            .onNodeWithTag("successMessage_id")
            .assertIsDisplayed()
    }
}