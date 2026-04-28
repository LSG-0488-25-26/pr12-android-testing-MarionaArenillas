package com.example.android_studio_test_exercice.viewmodel

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/* ViewModel encarregat de guardar l'estat de la pantalla i
gestionar tota la lògica de la MainView seguint el patró MVVM
*/
class MainViewModel : ViewModel() {

    // Estat del Switch (Wi-Fi activat o desactivat)
    private val _estatSwitch = MutableLiveData(true)
    val estatSwitch: LiveData<Boolean> = _estatSwitch

    // Checkbox de l'opció Vegetaria
    private val _esVegetaria = MutableLiveData(false)
    val esVegetaria: LiveData<Boolean> = _esVegetaria

    // Checkbox de l'opció Vega
    private val _esVega = MutableLiveData(false)
    val esVega: LiveData<Boolean> = _esVega

    // Checkbox de l'opció Carnivor
    private val _esCarnivor = MutableLiveData(true)
    val esCarnivor: LiveData<Boolean> = _esCarnivor

    // Estat del TriStateCheckbox (Off, Indeterminate o On)
    private val _triStateStatus = MutableLiveData(ToggleableState.Off)
    val triStateStatus: LiveData<ToggleableState> = _triStateStatus

    // Valor seleccionat del grup de RadioButtons
    private val _selectedOption = MutableLiveData("Messi")
    val selectedOption: LiveData<String> = _selectedOption

    // Valor actual del Slider
    private val _sliderValue = MutableLiveData(0f)
    val sliderValue: LiveData<Float> = _sliderValue

    // Controla si el DropdownMenu està obert o tancat
    private val _expanded = MutableLiveData(false)
    val expanded: LiveData<Boolean> = _expanded

    // Element seleccionat dins del DropdownMenu
    private val _selectedItem = MutableLiveData("Opció A")
    val selectedItem: LiveData<String> = _selectedItem

    // Text escrit dins del camp de cerca
    private val _searchText = MutableLiveData("")
    val searchText: LiveData<String> = _searchText

    // Controla si es mostra el missatge "Acció completada!"
    private val _showSnackbar = MutableLiveData(false)
    val showSnackbar: LiveData<Boolean> = _showSnackbar

    // Estat del botó final (Activat / Desactivat)
    private val _toggleState = MutableLiveData(false)
    val toggleState: LiveData<Boolean> = _toggleState

    // Inverteix l'estat del Switch
    fun toggleEstatSwitch() {
        _estatSwitch.value = !(_estatSwitch.value ?: true)
    }

    // Inverteix l'estat del checkbox Carnivor
    fun toggleEsCarnivor() {
        _esCarnivor.value = !(_esCarnivor.value ?: true)
    }

    // Inverteix l'estat del checkbox Vegetaria
    fun toggleEsVegetaria() {
        _esVegetaria.value = !(_esVegetaria.value ?: false)
    }

    // Inverteix l'estat del checkbox Vega
    fun toggleEsVega() {
        _esVega.value = !(_esVega.value ?: false)
    }

    // Canvia l'estat del TriStateCheckbox seguint aquest ordre:
    // Off → Indeterminate → On → Off
    fun toggleTriStateStatus() {
        _triStateStatus.value = when (_triStateStatus.value) {
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            null -> ToggleableState.Off
        }
    }

    // Guarda l'opció seleccionada del RadioButton
    fun setSelectedOption(option: String) {
        _selectedOption.value = option
    }

    // Actualitza el valor del Slider
    fun setSliderValue(value: Float) {
        _sliderValue.value = value
    }

    // Obre o tanca el DropdownMenu
    fun setExpanded(value: Boolean) {
        _expanded.value = value
    }

    // Guarda l'element seleccionat del DropdownMenu
    fun setSelectedItem(item: String) {
        _selectedItem.value = item
    }

    // Actualitza el text escrit al camp de cerca
    fun setSearchText(text: String) {
        _searchText.value = text
    }

    // Simula una cerca i mostra el missatge de confirmació
    fun performSearch() {
        _showSnackbar.value = true
    }

    // Canvia l'estat del botó final entre Activat i Desactivat
    fun toggle() {
        _toggleState.value = !(_toggleState.value ?: false)
    }
}