package com.project.condosa.data.remoto.api

import com.project.condosa.domain.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiPredioService {
    @GET("/getPredios")
    fun getPredios(): Call<ApiResponse> // ApiResponse es la clase que definimos anteriormente para modelar la respuesta
}