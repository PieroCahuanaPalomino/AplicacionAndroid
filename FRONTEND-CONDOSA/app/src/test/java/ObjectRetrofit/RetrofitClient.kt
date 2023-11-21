package ObjectRetrofit

import API.APIGastosCasas
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://successful-georgianne-apiflask.koyeb.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): APIGastosCasas {
        return retrofit.create(APIGastosCasas::class.java)
    }
}