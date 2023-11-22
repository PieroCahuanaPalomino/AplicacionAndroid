package com.project.condosa.domain.model

import com.google.gson.annotations.SerializedName

data class GastosCasasResponse(
    @SerializedName("ListaGastosComunes")
    val ListaGastosComunes: List<GastosCasas>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class GastosCasas(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id_predio")
    val idPredio: Int,
    @SerializedName("id_gasto")
    val idGasto: Int
)