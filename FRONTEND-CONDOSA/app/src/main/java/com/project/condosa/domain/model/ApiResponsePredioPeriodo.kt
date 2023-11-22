package com.project.condosa.domain.model

data class ApiResponsePredioPeriodo(
    val gastos : List<Periodo>,
    val message: String,
    val success : Boolean
)

data class Periodo(
    val id_predio_gastos : Int,
    val periodo : String
)