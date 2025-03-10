package br.com.fiap.ecopantry.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.ecopantry.model.Alimento
import br.com.fiap.ecopantry.viewmodel.EstoqueViewModel
import br.com.fiap.ecopantry.ui.components.BotaoFiltro
import br.com.fiap.ecopantry.ui.components.DropdownMenuFiltro
import br.com.fiap.ecopantry.ui.components.Header
import br.com.fiap.ecopantry.ui.theme.ItemAlimento
import br.com.fiap.ecopantry.util.isProximoVencimento
import br.com.fiap.ecopantry.util.isVencido

@Composable
fun EstoqueScreen() {
    var filtroSelecionado by remember { mutableStateOf("Todos") }

    val listaAlimentos = listOf(
        Alimento(1, "Leite", 2, "2025-03-12"),
        Alimento(2, "Maçã", 5, "2025-03-08"),
        Alimento(3, "Iogurte", 1, "2025-03-05")
    )

    val alimentosFiltrados = when (filtroSelecionado) {
        "Vencidos" -> listaAlimentos.filter { isVencido(it.dataValidade) }
        "Próximos" -> listaAlimentos.filter { isProximoVencimento(it.dataValidade) }
        else -> listaAlimentos
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Filtro suspenso
        DropdownMenuFiltro(filtroSelecionado) { filtroSelecionado = it }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(alimentosFiltrados) { alimento ->
                ItemAlimento(alimento)
            }
        }
    }
}
