package Model

import com.google.gson.annotations.SerializedName

data class EncargadoPredioResponse(
    @SerializedName("descripGastosComunes")
    val descripGastosComunes: List<EncargadoPredio>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class EncargadoPredio(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id_gasto")
    val idGasto: Int
)