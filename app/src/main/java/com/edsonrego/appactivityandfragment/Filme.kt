package com.edsonrego.appactivityandfragment

import java.io.Serializable

data class Filme(
    val nome: String,
    val descricao: String,
    val avaliacao: Double,
    val diretor: String,
    val distribuidora: String
) : Serializable
