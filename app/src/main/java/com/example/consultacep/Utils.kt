package com.example.jsonurl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {
    val BASE = "https://viacep.com.br"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE).addConverterFactory(GsonConverterFactory.create()).build()
    }
}