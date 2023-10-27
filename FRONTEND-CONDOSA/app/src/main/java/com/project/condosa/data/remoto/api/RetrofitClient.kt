package com.project.condosa.data.remoto.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:5000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiPredioService= retrofit.create(ApiPredioService::class.java)
}