package com.project.condosa.data.remoto.ImplementacionAPI

import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.domain.model.GastoPredio
import com.project.condosa.domain.model.GastoPredioResponse
import com.project.condosa.domain.model.TipoGastoPredio
import com.project.condosa.domain.model.TipoGastoPredioResponse

class APIGastoPredioImplementacion {
    private val apiGastoPredioService = RetrofitClient.getInstanceGasto()


    suspend fun getTipoGastosComunes(): List<TipoGastoPredio> {
        val response: TipoGastoPredioResponse = apiGastoPredioService.getTipoGastosComunes()
        return response.tipoGastosComunes
    }

    suspend fun getGastosComunesTipo(id: Int): List<GastoPredio>? {
        val response: GastoPredioResponse = apiGastoPredioService.getGastosComunesTipo(id)
        return response.descripGastosComunes
    }
}