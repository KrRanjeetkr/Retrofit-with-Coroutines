package com.example.retrofitwithcoroutin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(Url.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)

    }

}