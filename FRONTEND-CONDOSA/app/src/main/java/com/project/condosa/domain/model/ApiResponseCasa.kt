package com.project.condosa.domain.model

data class ApiResponseCasa(
    val message: String,
    val casas: List<Casa>,
    val success: Boolean
)