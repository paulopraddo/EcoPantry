package br.com.fiap.ecopantry.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(content: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFFF9800)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botão de Filtros à Esquerda
        Box(modifier = Modifier.padding(start = 8.dp)) {
            content()
        }

        // Título Centralizado
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "EcoPantry",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


