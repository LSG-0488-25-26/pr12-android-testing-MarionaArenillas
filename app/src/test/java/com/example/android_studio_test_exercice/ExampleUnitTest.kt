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
}