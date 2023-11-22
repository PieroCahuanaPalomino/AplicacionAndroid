package com.project.condosa.data.remoto.ImplementacionAPI

import android.util.Log
import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.domain.model.GastosCasas
import com.project.condosa.domain.model.GastosCasasResponse
import com.project.condosa.domain.model.ListaCasasResponse
import retrofit2.Response

class APIGastoCasaImplementacion {
    private val apiListaCasasService = RetrofitClient.getInstanceCasas()

    suspend fun getListaCasasDelPredio(id: Int): Response<ListaCasasResponse> {
        val response: Response<ListaCasasResponse> = apiListaCasasService.getListaCasasDelPredio(id)
        return response
    }

    suspend fun getGastosCasasPredio(id: Int): List<GastosCasas> {
        return try {
            val response: GastosCasasResponse = apiListaCasasService.getGastosCasasPredio(id)
            return response.ListaGastosComunes
        }
        catch (e: Exception){
            Log.e("Error API","error al conectarse a la API",e)
            emptyList()
        }
    }

}