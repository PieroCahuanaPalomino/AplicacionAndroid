package com.project.condosa.data.remoto.api

import com.google.gson.annotations.SerializedName
import com.project.condosa.domain.model.ApiResponsePredio
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPredioService {
    @GET("predios/getPredios")
    suspend fun getPredios(): Response<ApiResponsePredio> // ApiResponse es la clase que definimos anteriormente para modelar la respuesta

    @GET("/api/10229233666327556/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String) :Response<SupperHeroResponse>
}

data class SupperHeroResponse(@SerializedName("response") val response:String)





