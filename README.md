## Android Testing: Unit Testing + UI Testing

Aquesta pràctica completa una aplicació Android amb Kotlin i Jetpack Compose seguint el patró MVVM.

### Arquitectura MVVM

- `MainView.kt`: conté la interfície d'usuari amb Compose.
- `MainViewModel.kt`: conté els estats amb LiveData i la lògica de la pantalla.
- `ExampleUnitTest.kt`: comprova els mètodes del ViewModel.
- `ExampleInstrumentedTest.kt`: comprova els composables de la MainView.

### Unit Testing

S'han creat tests per comprovar tots els mètodes del ViewModel:

- `toggleEstatSwitch()`
- `toggleEsVegetaria()`
- `toggleEsVega()`
- `toggleEsCarnivor()`
- `toggleTriStateStatus()`
- `setSelectedOption()`
- `setSliderValue()`
- `setExpanded()`
- `setSelectedItem()`
- `setSearchText()`
- `performSearch()`
- `toggle()`

Captura dels Unit Tests:

![Unit Tests](docs/ExampleUnitTest.png)

### Instrumental UI Testing

S'han creat tests de UI per comprovar els composables principals:

- Switch Wi-Fi
- Checkboxes
- TriStateCheckbox
- RadioButtons
- Slider
- DropdownMenu
- TextField de cerca
- Botó Buscar
- Botó Activat/Desactivat

Captura dels UI Tests:

![UI Tests](docs/ExampleInstrumentedTest.png)
