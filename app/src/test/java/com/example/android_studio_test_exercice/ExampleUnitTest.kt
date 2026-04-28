package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {

    // Fa que LiveData funcioni de forma síncrona durant els tests
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // ViewModel que testejarem
    private lateinit var viewModel: MainViewModel

    // S'executa abans de cada test
    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    // Comprova els valors inicials del ViewModel
    @Test
    fun initialState() {
        assertEquals(true, viewModel.estatSwitch.value)
        assertEquals(false, viewModel.esVegetaria.value)
        assertEquals(false, viewModel.esVega.value)
        assertEquals(true, viewModel.esCarnivor.value)
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
        assertEquals("Messi", viewModel.selectedOption.value)
    }

    // Comprova que el mètode toggleEstatSwitch()
    // canvia l'estat del Switch de true a false i de false a true
    @Test
    fun checkToggleEstatSwitch() {
        viewModel.toggleEstatSwitch()
        assertEquals(false, viewModel.estatSwitch.value)

        viewModel.toggleEstatSwitch()
        assertEquals(true, viewModel.estatSwitch.value)
    }

    // Comprova que el mètode toggleEsVegetaria()
    // activa i desactiva el checkbox de Vegetaria
    @Test
    fun checkToggleEsVegetaria() {
        viewModel.toggleEsVegetaria()
        assertEquals(true, viewModel.esVegetaria.value)

        viewModel.toggleEsVegetaria()
        assertEquals(false, viewModel.esVegetaria.value)
    }

    // Comprova que el mètode toggleEsVega()
    // activa i desactiva el checkbox de Vega
    @Test
    fun checkToggleEsVega() {
        viewModel.toggleEsVega()
        assertEquals(true, viewModel.esVega.value)

        viewModel.toggleEsVega()
        assertEquals(false, viewModel.esVega.value)
    }

    // Comprova que el mètode toggleEsCarnivor()
    // desactiva i torna a activar el checkbox de Carnivor
    @Test
    fun checkToggleEsCarnivor() {
        viewModel.toggleEsCarnivor()
        assertEquals(false, viewModel.esCarnivor.value)

        viewModel.toggleEsCarnivor()
        assertEquals(true, viewModel.esCarnivor.value)
    }

    // Comprova que el TriStateCheckbox canvia correctament
    // entre Off → Indeterminate → On → Off
    @Test
    fun checkToggleTriStateStatus() {
        viewModel.toggleTriStateStatus()
        assertEquals(
            ToggleableState.Indeterminate,
            viewModel.triStateStatus.value
        )

        viewModel.toggleTriStateStatus()
        assertEquals(
            ToggleableState.On,
            viewModel.triStateStatus.value
        )

        viewModel.toggleTriStateStatus()
        assertEquals(
            ToggleableState.Off,
            viewModel.triStateStatus.value
        )
    }
}