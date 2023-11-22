package com.project.condosa.domain.model

import com.google.gson.annotations.SerializedName

data class GastoPredioResponse(
    @SerializedName("descripGastosComunes")
    val descripGastosComunes: List<GastoPredio>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class GastoPredio(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id_gasto")
    val idGasto: Int
)