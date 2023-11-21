package com.project.condosa.data.remoto.ImplementacionApi


import com.project.condosa.data.remoto.ObjectRetrofit.RetrofitClient
import com.project.condosa.domain.model.ApiResponsePredio
import com.project.condosa.domain.model.ApiResponsePredioPeriodo
import com.project.condosa.domain.model.ApiResponsePredioSingle

import retrofit2.Response

class ApiPredioServiceImplementation {
    private val apiPredioService = RetrofitClient.getInstance()


    suspend fun getPredios(): Response<ApiResponsePredio>{
        val response : Response <ApiResponsePredio> = apiPredioService.getPredios();
        return response;
    }

    suspend fun getPrediosPeriodo(id:Int): Response<ApiResponsePredioPeriodo>{
        val response : Response <ApiResponsePredioPeriodo> = apiPredioService.getPrediosPeriodo(id);
        return response;
    }

    suspend fun getPredio(id:Int): Response<ApiResponsePredioSingle>{
        val response : Response <ApiResponsePredioSingle> = apiPredioService.getPredio(id);
        return response;
    }
}