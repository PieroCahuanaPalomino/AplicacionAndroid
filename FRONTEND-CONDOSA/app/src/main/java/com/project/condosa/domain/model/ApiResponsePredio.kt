package com.project.condosa.domain.model

data class ApiResponsePredio(
    val message: String,
    val predios: List<Predio>,
    val success: Boolean
)

data class ApiResponsePredioSingle(
    val message: String,
    val predio: List<Predio>,
    val success: Boolean
)