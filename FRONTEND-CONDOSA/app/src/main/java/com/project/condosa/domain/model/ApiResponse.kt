package com.project.condosa.domain.model

data class ApiResponse(
    val message: String,
    val predios: List<Predio>,
    val success: Boolean
)