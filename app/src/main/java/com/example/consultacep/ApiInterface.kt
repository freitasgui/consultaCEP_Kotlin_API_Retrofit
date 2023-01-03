package com.example.consultacep

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/ws/{cepBuscado}/json/")
    suspend fun getCep(@Path("cepBuscado") cep : String): Response<cepItem>
}