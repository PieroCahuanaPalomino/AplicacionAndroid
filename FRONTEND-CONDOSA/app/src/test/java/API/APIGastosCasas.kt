package API

import Model.EncargadoPredioResponse
import Model.GastosCasasResponse
import Model.TipoGastosCasasResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGastosCasas {
    @GET("getTipoGastosComunes")
    suspend fun getTipoGastosComunes(): TipoGastosCasasResponse

    @GET("getTipoGastosComunes/{id}")
    suspend fun getGastosComunesTipo(@Path("id") id: Int): GastosCasasResponse

    //@GET("getPredios")
    //suspend fun getTipoGastosComunes(): EncargadoPredioResponse


}