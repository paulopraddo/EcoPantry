package br.com.fiap.ecopantry.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fiap.ecopantry.model.Alimento
import br.com.fiap.ecopantry.util.isProximoVencimento
import br.com.fiap.ecopantry.util.isVencido


@Composable
fun ItemAlimento(alimento: Alimento) {
    val corStatus = when {
        isVencido(alimento.dataValidade) -> Color.Red
        isProximoVencimento(alimento.dataValidade) -> Color.Yellow
        else -> Color.Green
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(corStatus.copy(alpha = 0.2f))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = alimento.nome, fontWeight = FontWeight.Bold)
                    Text(text = "Quantidade: ${alimento.quantidade}")
                    Text(text = "Vence em: ${alimento.dataValidade}")
                }
                IconButton(onClick = { /* Editar alimento */ }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
                }
                IconButton(onClick = { /* Excluir alimento */ }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir", tint = Color.Red)
                }
            }
        }
    }

}
