package com.example.app10

data class Persona(
    val nombre: String,
    val peso: String,
    val altura: String
)

object DatosPersonas {
    val lista = mutableListOf<Persona>()
}