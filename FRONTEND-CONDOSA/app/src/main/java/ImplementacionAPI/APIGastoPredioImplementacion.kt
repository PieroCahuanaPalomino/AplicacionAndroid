package ImplementacionAPI

import ObjectRetrofit.RetrofitClient
import model.GastoPredio
import model.GastoPredioResponse
import model.TipoGastoPredio
import model.TipoGastoPredioResponse

class APIGastoPredioImplementacion {
    private val apiGastoPredioService = RetrofitClient.getInstance()


    suspend fun getTipoGastosComunes(): List<TipoGastoPredio> {
        val response: TipoGastoPredioResponse = apiGastoPredioService.getTipoGastosComunes()
        return response.tipoGastosComunes
    }

    suspend fun getGastosComunesTipo(id: Int): List<GastoPredio>? {
        val response: GastoPredioResponse = apiGastoPredioService.getGastosComunesTipo(id)
        return response.descripGastosComunes
    }
}