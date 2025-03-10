package br.com.fiap.ecopantry.util

import java.time.LocalDate

fun isVencido(dataValidade: String): Boolean {
    val hoje = LocalDate.now()
    val data = LocalDate.parse(dataValidade)
    return data.isBefore(hoje)
}

fun isProximoVencimento(dataValidade: String): Boolean {
    val hoje = LocalDate.now()
    val data = LocalDate.parse(dataValidade)
    return data.isBefore(hoje.plusDays(3)) && data.isAfter(hoje)
}