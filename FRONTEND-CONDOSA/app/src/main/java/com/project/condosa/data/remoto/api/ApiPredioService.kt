package com.project.condosa.data.remoto.api

import com.project.condosa.domain.model.ApiResponsePredio
import retrofit2.Call
import retrofit2.http.GET

interface ApiPredioService {
    @GET("predios/getPredios")
    fun getPredios(): Call<ApiResponsePredio> // ApiResponse es la clase que definimos anteriormente para modelar la respuesta
}





