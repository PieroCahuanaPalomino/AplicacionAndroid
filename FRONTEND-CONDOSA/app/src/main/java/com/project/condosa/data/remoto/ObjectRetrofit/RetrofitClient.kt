package com.project.condosa.data.remoto.ObjectRetrofit

import com.project.condosa.data.remoto.api.APIGastoPredio
import com.project.condosa.data.remoto.api.APIGastosCasas
import com.project.condosa.data.remoto.api.ApiPredioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://successful-georgianne-apiflask.koyeb.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): ApiPredioService {
        return retrofit.create(ApiPredioService::class.java)
    }

    fun getInstanceGasto(): APIGastoPredio {
        return retrofit.create(APIGastoPredio::class.java)
    }

    fun getInstanceCasas(): APIGastosCasas {
        return retrofit.create(APIGastosCasas::class.java)
    }
}