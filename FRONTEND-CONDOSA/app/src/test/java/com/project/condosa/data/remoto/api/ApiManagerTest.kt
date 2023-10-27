package com.project.condosa.data.remoto.api


import com.project.condosa.domain.model.ApiResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiManagerTest {
/*
    @Test
    fun retro(){
        val retrofitTraer= RetrofitClient.apiPredioService.getPredios()
        retrofitTraer.enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                Assert.assertTrue(true)
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Assert.assertFalse(true)
            }

        })
    }*/

    @Test
    fun testRetrofitRequest() {
        // Obtiene la instancia existente de Retrofit desde RetrofitClient
        val apiService = RetrofitClient.apiPredioService

        // Realiza la solicitud en un hilo en segundo plano
        val call = apiService.getPredios()
        val response = call.execute()

        if (response.isSuccessful) {
            val apiResponse = response.body()
            println("Respuesta exitosa: $apiResponse") // Imprime la respuesta exitosa en la consola
            Assert.assertNotNull(apiResponse)
            // Realiza más aserciones según tus necesidades
        } else {
            println("La solicitud no fue exitosa") // Imprime un mensaje en la consola
            Assert.fail("La solicitud no fue exitosa")
        }
    }

}

