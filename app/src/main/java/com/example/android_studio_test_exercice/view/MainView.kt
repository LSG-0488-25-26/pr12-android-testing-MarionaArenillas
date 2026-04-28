package com.example.android_studio_test_exercice.view

// Vista principal de l'aplicació.

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.testTag
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

// Rep el ViewModel per poder llegir els estats i cridar els seus mètodes.
@Composable
fun MainView(myViewModel: MainViewModel, modifier: Modifier = Modifier) {

    // Ens subscrivim als LiveData del ViewModel.
    // Quan un valor canvia, Compose torna a pintar automàticament la part afectada.
    val estatSwitch by myViewModel.estatSwitch.observeAsState(true)
    val esVegetaria by myViewModel.esVegetaria.observeAsState(true)
    val esVega by myViewModel.esVega.observeAsState(false)
    val esCarnivor by myViewModel.esCarnivor.observeAsState(true)
    val triStateStatus by myViewModel.triStateStatus.observeAsState(ToggleableState.Off)
    val selectedOption by myViewModel.selectedOption.observeAsState("Messi")

    // Estats dels altres composables de la pantalla
    val sliderValue by myViewModel.sliderValue.observeAsState(0f)
    val expanded by myViewModel.expanded.observeAsState(false)
    val selectedItem by myViewModel.selectedItem.observeAsState("Opció A")
    val searchText by myViewModel.searchText.observeAsState("")
    val showSnackbar by myViewModel.showSnackbar.observeAsState(false)
    val toggleState by myViewModel.toggleState.observeAsState(false)

    // Contenidor general de tota la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 60.dp)
    ) {

        // Organitza tots els elements verticalment
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // Primera fila: text + Switch del Wi-Fi
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Activar Wi-Fi: ",
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(0.dp, 10.dp),
                    fontSize = 25.sp
                )

                // Switch connectat amb l'estat estatSwitch del ViewModel
                Switch(
                    checked = estatSwitch,
                    onCheckedChange = { myViewModel.toggleEstatSwitch() },
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        // testTag per poder localitzar aquest Switch als tests de UI
                        .testTag("wifiSwitch_id"),
                    enabled = true,
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.LightGray,
                        checkedThumbColor = Color.Black
                    )
                )
            }

            // Bloc de checkboxes d'opcions de menú
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(0.dp, 20.dp)
            ) {
                Text(
                    text = "Opcions de menú:",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 25.sp
                )

                // Capçaleres dels tres checkboxes
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp)
                ) {
                    Text("Carnívor/a", Modifier.align(CenterVertically).fillMaxWidth(0.33f))
                    Text("Vegetarià/na", Modifier.align(CenterVertically).fillMaxWidth(0.6f))
                    Text("Vegà/na", Modifier.align(CenterVertically).fillMaxWidth(1f))
                }

                // Checkboxes connectats amb el ViewModel
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                ) {
                    // Checkbox Carnívor/a.
                    // Està deshabilitat, per tant l'usuari no el pot modificar des de la UI.
                    Checkbox(
                        checked = esCarnivor,
                        onCheckedChange = { myViewModel.toggleEsCarnivor() },
                        modifier = Modifier
                            .fillMaxWidth(0.20f)
                            .testTag("carnivorCheckbox_id"),
                        enabled = false,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black
                        )
                    )

                    // Checkbox Vegetarià/na
                    Checkbox(
                        checked = esVegetaria,
                        onCheckedChange = { myViewModel.toggleEsVegetaria() },
                        modifier = Modifier
                            .fillMaxWidth(0.33f)
                            .testTag("vegetariaCheckbox_id"),
                        enabled = true,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black
                        )
                    )

                    // Checkbox Vegà/na
                    Checkbox(
                        checked = esVega,
                        onCheckedChange = { myViewModel.toggleEsVega() },
                        modifier = Modifier
                            .fillMaxWidth(0.33f)
                            .testTag("vegaCheckbox_id"),
                        enabled = true,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black
                        )
                    )
                }
            }

            // TriStateCheckbox: pot tenir tres estats diferents
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("TriState", Modifier.fillMaxWidth(), fontSize = 20.sp)

                // Cada clic canvia l'estat: Off → Indeterminate → On → Off
                TriStateCheckbox(
                    state = triStateStatus,
                    onClick = { myViewModel.toggleTriStateStatus() },
                    // testTag per localitzar el TristateCheckbox als tests de UI
                    modifier = Modifier.testTag("triStateCheckbox_id")
                )
            }

            // Grup de RadioButtons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text("Pilota d'Or:", fontSize = 20.sp)

                // Es creen tres RadioButtons a partir d'una llista
                listOf("Vinicius", "Lamine Yamal", "Raphina").forEach { player ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedOption == player,
                            onClick = { myViewModel.setSelectedOption(player) },
                            // testTag diferent per cada RadioButton segons el jugador
                            modifier = Modifier.testTag(player.replace(" ", "") + "_radio_id"),
                            enabled = player != "Vinicius", // Vinicius queda deshabilitat
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                                unselectedColor = Color.LightGray
                            )
                        )

                        Text(player, Modifier.padding(start = 8.dp))
                    }
                }
            }

            // Text que mostra el valor actual del Slider
            Text("Volum: ${sliderValue.toInt()}%")

            // Slider per seleccionar un valor entre 0 i 100
            Slider(
                value = sliderValue,
                onValueChange = { myViewModel.setSliderValue(it) },
                valueRange = 0f..100f,
                // testTag per localitzar el Slider als tests de UI
                modifier = Modifier.testTag("slider_id")
            )

            // DropdownMenu: menú desplegable amb diferents opcions
            Box(modifier = Modifier.wrapContentSize()) {
                Text(
                    text = selectedItem,
                    modifier = Modifier
                        .clickable {
                        // Obrim el menú quan es clica el text
                        myViewModel.setExpanded(true)
                        }
                        // testTag per localitzar el text que obre el DropdownMenu
                        .testTag("dropdownText_id")
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        // Tanquem el menú quan es clica fora
                        myViewModel.setExpanded(false)
                    }
                ) {
                    listOf("Opció A", "Opció B", "Opció C").forEach { option ->
                        DropdownMenuItem(
                            // cada opció del menú té un testTag diferent
                            text = {
                                Text(
                                    text = option,
                                    modifier = Modifier.testTag("${option}_dropdownItem_id")
                                )
                            },
                            onClick = {
                                // Guardem l'opció seleccionada i tanquem el menú
                                myViewModel.setSelectedItem(option)
                                myViewModel.setExpanded(false)
                            }
                        )
                    }
                }
            }

            // Camp de text per escriure una cerca
            OutlinedTextField(
                value = searchText,
                onValueChange = { myViewModel.setSearchText(it) },
                label = { Text("Buscar...") },
                // testTag per localitzar el camp de text als tests de UI
                modifier = Modifier.testTag("searchTextField_id"),
            )

            // Botó que executa la cerca
            Button(
                onClick = { myViewModel.performSearch() },
                // testTag per localitzar el botó Buscar als tests de UI
                modifier = Modifier.testTag("searchButton_id")
            ) {
                Text("Buscar")
            }

            // Missatge que només es mostra després de prémer el botó Buscar
            if (showSnackbar) {
                Text(
                    text = "Acció completada!",
                    color = Color.Green,
                    // testTag per comprovar-lo als tests de UI
                    modifier = Modifier.testTag("successMessage_id")
                )
            }

            // Botó final que canvia de color i de text segons l'estat
            Button(
                onClick = { myViewModel.toggle() },
                // testTag per localitzar el boto final als test de UI
                modifier = Modifier.testTag("toggleButton_id"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (toggleState) Color.Green else Color.Red
                )
            ) {
                Text(if (toggleState) "Activat" else "Desactivat")
            }
        }
    }
}