package com.project.condosa.domain.model

import com.google.gson.annotations.SerializedName

data class TipoGastoPredioResponse(
    val message: String,
    val success: Boolean,
    @SerializedName("tipoGastosComunes")
    val tipoGastosComunes: List<TipoGastoPredio>
)

data class TipoGastoPredio(
    @SerializedName("descripcion")
    var descripcion: String,
    @SerializedName("id_tipo_gasto")
    var id_tipo_gasto: Int
)