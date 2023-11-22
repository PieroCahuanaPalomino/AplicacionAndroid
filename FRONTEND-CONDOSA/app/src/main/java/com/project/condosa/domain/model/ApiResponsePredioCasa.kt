package com.project.condosa.domain.model

data class ApiResponsePredio(
    val message: String,
    val predios: List<Predio>,
    val success: Boolean
)