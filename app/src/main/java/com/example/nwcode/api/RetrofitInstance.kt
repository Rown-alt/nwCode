package com.example.nwcode.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .build()
    }
    val api:UnsplashAPI by lazy {
        retrofit.create(UnsplashAPI::class.java)
    }
}