package br.com.fiap.ecopantry.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.fiap.ecopantry.model.Alimento
import br.com.fiap.ecopantry.ui.components.BotaoFiltro
import br.com.fiap.ecopantry.ui.components.DropdownMenuFiltro
import br.com.fiap.ecopantry.ui.components.Header
import br.com.fiap.ecopantry.ui.theme.ItemAlimento
import br.com.fiap.ecopantry.util.isProximoVencimento
import br.com.fiap.ecopantry.util.isVencido

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Estoque",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                        },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFA500)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            DropdownMenuFiltro(filtroSelecionado) { filtroSelecionado = it }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(alimentosFiltrados) { alimento ->
                    ItemAlimento(alimento)
                }
            }
        }
    }
}
