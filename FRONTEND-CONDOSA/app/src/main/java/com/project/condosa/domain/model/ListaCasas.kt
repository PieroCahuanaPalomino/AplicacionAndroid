package com.project.condosa.domain.model

import com.google.gson.annotations.SerializedName

data class ListaCasasResponse(
    @SerializedName("casas")
    val casas: List<ListaCasas>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class ListaCasas(
    @SerializedName("area_casa")
    val areaCasa: Double,
    @SerializedName("area_cochera")
    val areaCochera: Double,
    @SerializedName("area_total")
    val areaTotal: Double,
    @SerializedName("estado")
    val estado: String,
    @SerializedName("id_casa")
    val idCasa: Int,
    @SerializedName("id_indice")
    val idIndice : Int,
    @SerializedName("id_predio")
    val idPredio: Int,
    @SerializedName("mdu")
    val mdu: String,
    @SerializedName("numero")
    val numero : Int,
    @SerializedName("participacion")
    val participacion: Double,
    @SerializedName("piso")
    val piso: Int,
    @SerializedName("resposable")
    val Responsable: String

)