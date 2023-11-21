package API_implementacion

import Model.GastosCasas
import Model.GastosCasasResponse
import Model.TipoGastosCasas
import Model.TipoGastosCasasResponse
import ObjectRetrofit.RetrofitClient

class APIGastoCasaImplementacion {
    private val apiGastoPredioService = RetrofitClient.getInstance()


    suspend fun getTipoGastosComunes(): List<TipoGastosCasas> {
        val response: TipoGastosCasasResponse = apiGastoPredioService.getTipoGastosComunes()
        return response.tipoGastosComunes
    }

    suspend fun getGastosComunesTipo(id: Int): List<GastosCasas>? {
        val response: GastosCasasResponse = apiGastoPredioService.getGastosComunesTipo(id)
        return response.descripGastosComunes
    }
}