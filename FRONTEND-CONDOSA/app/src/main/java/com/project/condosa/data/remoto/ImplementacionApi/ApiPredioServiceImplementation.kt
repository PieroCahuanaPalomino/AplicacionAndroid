package com.project.condosa.data.remoto.ImplementacionApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.domain.model.ApiResponsePredio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class ApiPredioServiceImplementation {
    private val apiPredioService = RetrofitClient.apiPredioService

    suspend fun getPredios(): ApiResponsePredio {
        return suspendCoroutine { continuation ->
            apiPredioService.getPredios().enqueue(object : Callback<ApiResponsePredio> {
                override fun onResponse(call: Call<ApiResponsePredio>, response: Response<ApiResponsePredio>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            continuation.resume(responseBody)
                        } else {
                            continuation.resumeWithException(Exception("Respuesta nula"))
                        }
                    } else {
                        continuation.resumeWithException(Exception("Error en la solicitud: ${response.code()} - ${response.message()}"))
                    }
                }

                override fun onFailure(call: Call<ApiResponsePredio>, t: Throwable) {
                    continuation.resumeWithException(Exception("Error en la solicitud: ${t.message}"))
                }
            })
        }
    }
}