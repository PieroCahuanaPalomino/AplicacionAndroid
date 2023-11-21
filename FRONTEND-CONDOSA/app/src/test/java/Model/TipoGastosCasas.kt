package Model

import com.google.gson.annotations.SerializedName

data class TipoGastosCasasResponse(
    val message: String,
    val success: Boolean,
    @SerializedName("tipoGastosComunes")
    val tipoGastosComunes: List<TipoGastosCasas>
)

data class TipoGastosCasas(
    @SerializedName("descripcion")
    var descripcion: String,
    @SerializedName("id_tipo_gasto")
    var id_tipo_gasto: Int
)