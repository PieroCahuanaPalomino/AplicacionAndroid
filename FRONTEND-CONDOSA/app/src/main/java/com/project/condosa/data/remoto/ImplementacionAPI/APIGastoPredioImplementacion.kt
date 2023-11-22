package com.project.condosa.data.remoto.ImplementacionAPI

import android.util.Log
import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.domain.model.GastoPredio
import com.project.condosa.domain.model.GastoPredioResponse
import com.project.condosa.domain.model.TipoGastoPredio
import com.project.condosa.domain.model.TipoGastoPredioResponse
import retrofit2.HttpException
import java.lang.Exception

class APIGastoPredioImplementacion {
    private val apiGastoPredioService = RetrofitClient.getInstanceGasto()


    suspend fun getTipoGastosComunes(): List<TipoGastoPredio> {
        //return response.tipoGastosComunes
        return try {
            val response: TipoGastoPredioResponse = apiGastoPredioService.getTipoGastosComunes()
            response.tipoGastosComunes
        } catch (e: Exception) {
            Log.e("ERROR API", "error al conectarse a la api", e)
            emptyList()
        }
    }

    suspend fun getGastosComunesTipo(id: Int): List<GastoPredio>? {
        //return response.descripGastosComunes
        return try {
            val response: GastoPredioResponse = apiGastoPredioService.getGastosComunesTipo(id)
            response.descripGastosComunes
        } catch (e: Exception) {
            Log.e("ERROR API", "error al conectarse a la api", e)
            emptyList()
        }
    }
}