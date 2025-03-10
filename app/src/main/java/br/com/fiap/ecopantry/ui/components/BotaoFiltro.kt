package br.com.fiap.ecopantry.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun BotaoFiltro(filtroAtual: String, onFiltroSelecionado: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val opcoes = listOf("Todos", "Leite", "Maçã", "Iogurte", "Arroz")

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Filtros Avançados", color = Color.Black)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opcoes.forEach { opcao ->
                DropdownMenuItem(
                    text = { Text(opcao) },
                    onClick = {
                        onFiltroSelecionado(opcao)
                        expanded = false
                    }
                )
            }
        }
    }
}
