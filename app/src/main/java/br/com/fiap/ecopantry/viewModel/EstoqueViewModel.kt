package br.com.fiap.ecopantry.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.fiap.ecopantry.model.Alimento

class EstoqueViewModel : ViewModel() {
    // Lista inicial de alimentos
    private val listaAlimentosOriginais = listOf(
        Alimento(1, "Leite", 2, "2025-03-12"),
        Alimento(2, "Maçã", 5, "2025-03-08"),
        Alimento(3, "Iogurte", 1, "2025-03-05"),
        Alimento(4, "Arroz", 3, "2025-04-01")
    )

    var filtroSelecionado = mutableStateOf("")
        private set

    var listaAlimentos = mutableStateOf(listaAlimentosOriginais)
        private set

    // Atualiza o filtro e refiltra a lista
    fun atualizarFiltro(novoFiltro: String) {
        filtroSelecionado.value = novoFiltro
        listaAlimentos.value = if (novoFiltro.isEmpty()) {
            listaAlimentosOriginais
        } else {
            listaAlimentosOriginais.filter { it.nome.contains(novoFiltro, ignoreCase = true) }
        }
    }
}
