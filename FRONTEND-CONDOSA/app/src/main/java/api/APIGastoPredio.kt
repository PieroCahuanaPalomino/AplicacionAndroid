package api

import model.GastoPredio
import model.GastoPredioResponse
import model.TipoGastoPredio
import model.TipoGastoPredioResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGastoPredio {
    @GET("getTipoGastosComunes")
    suspend fun getTipoGastosComunes(): TipoGastoPredioResponse

    @GET("getTipoGastosComunes/{id}")
    suspend fun getGastosComunesTipo(@Path("id") id: Int): GastoPredioResponse
}