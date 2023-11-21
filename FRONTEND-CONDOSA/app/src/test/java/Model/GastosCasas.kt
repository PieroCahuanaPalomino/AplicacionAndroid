package Model

import com.google.gson.annotations.SerializedName

data class GastosCasasResponse(
    @SerializedName("descripGastosComunes")
    val descripGastosComunes: List<GastosCasas>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class GastosCasas(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id_gasto")
    val idGasto: Int
)