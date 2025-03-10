package br.com.fiap.ecopantry.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun DropdownMenuFiltro(filtroSelecionado: String, onFiltroSelecionado: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val opcoes = listOf("Todos", "Vencidos", "Próximos")

    Box(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { expanded = true }) {
            Text(text = filtroSelecionado)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } // Fecha o menu quando o usuário clica fora
        ) {
            opcoes.forEach { opcao ->
                DropdownMenuItem(
                    text = { Text(text = opcao) }, // Nova forma recomendada
                    onClick = {
                        onFiltroSelecionado(opcao) // Atualiza o filtro
                        expanded = false // Fecha o menu
                    }
                )
            }
        }
    }
}

