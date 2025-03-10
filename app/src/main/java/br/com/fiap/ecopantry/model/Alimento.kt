package br.com.fiap.ecopantry.model

data class Alimento(
    val id: Int,
    val nome: String,
    val quantidade: Int,
    val dataValidade: String
)