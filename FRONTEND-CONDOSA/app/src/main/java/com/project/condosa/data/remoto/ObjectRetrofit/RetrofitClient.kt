package com.project.condosa.data.remoto.ObjectRetrofit

import com.project.condosa.data.remoto.api.ApiPredioService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    //https://successful-georgianne-apiflask.koyeb.app/
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://apimocha.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

     fun getInstance():ApiPredioService{
        return retrofit.create(ApiPredioService::class.java)
    }

}