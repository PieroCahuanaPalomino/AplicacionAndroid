package com.project.condosa.domain.model

import com.google.gson.annotations.SerializedName

data class GastoCResponse(
    @SerializedName("descripGastosComunes")
    val descripGastosComunes: List<GastoPredio>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class GastoC(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id_gasto")
    val idGasto: Int
)