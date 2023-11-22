package com.project.condosa.data.remoto.api

import com.project.condosa.domain.model.GastosCasasResponse
import com.project.condosa.domain.model.ListaCasasResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGastosCasas {
    @GET("getPredios/{id}/getCasas")
    suspend fun getListaCasasDelPredio(@Path("id") id: Int): Response<ListaCasasResponse>

    @GET("getGastosPredios/{id}")
    suspend fun getGastosCasasPredio(@Path("id") id: Int): GastosCasasResponse
}