package com.project.condosa.data.remoto.api

import com.project.condosa.domain.model.GastoPredioResponse
import com.project.condosa.domain.model.TipoGastoPredioResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGastoPredio {
    @GET("getTipoGastosComunes")
    suspend fun getTipoGastosComunes(): TipoGastoPredioResponse

    @GET("getTipoGastosComunes/{id}")
    suspend fun getGastosComunesTipo(@Path("id") id: Int): GastoPredioResponse
}