package com.project.condosa.data.remoto.ObjectRetrofit

import com.project.condosa.data.remoto.api.APIGastoPredio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://successful-georgianne-apiflask.koyeb.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): APIGastoPredio {
        return retrofit.create(APIGastoPredio::class.java)
    }
}