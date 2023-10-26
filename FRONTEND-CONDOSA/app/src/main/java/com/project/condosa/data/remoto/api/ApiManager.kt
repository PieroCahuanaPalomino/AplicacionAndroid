package com.project.condosa.data.remoto.api

import com.project.condosa.domain.model.ApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    private val apiService: ApiPredioService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiPredioService::class.java)
    }

    fun getPredios(callback: (ApiResponse?) -> Unit) {
        val call = apiService.getPredios()
        call.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: retrofit2.Response<ApiResponse>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}
