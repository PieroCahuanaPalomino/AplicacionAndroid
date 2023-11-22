package com.project.condosa.data.remoto.api

import com.google.gson.annotations.SerializedName
import com.project.condosa.domain.model.ApiResponseCasa
import com.project.condosa.domain.model.ApiResponsePredio
import com.project.condosa.domain.model.ApiResponsePredioPeriodo
import com.project.condosa.domain.model.ApiResponsePredioSingle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPredioService {
    @GET("getPredios")
    suspend fun getPredios(): Response<ApiResponsePredio> // ApiResponse es la clase que definimos anteriormente para modelar la respuesta

    @GET("getPredios/{id}")
    suspend fun getPrediosPeriodo(@Path("id")id:Int): Response<ApiResponsePredioPeriodo> // ApiResponse es la clase que definimos anteriormente para modelar la respuesta

    @GET("getPredio/{id}")
    suspend fun getPredio(@Path("id")id:Int): Response<ApiResponsePredioSingle>

    @GET("getPredios/{id}/getCasas")
    suspend fun getCasa(@Path("id")id:Int): Response<ApiResponseCasa>

    @GET("/api/10229233666327556/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String) :Response<SupperHeroResponse>
}

data class SupperHeroResponse(@SerializedName("response") val response:String)





