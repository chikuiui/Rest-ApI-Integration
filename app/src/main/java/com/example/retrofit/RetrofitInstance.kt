package com.example.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitInstance {

    companion object{
        val baseUrl = "https://jsonplaceholder.typicode.com"

        fun getRetrofitInstance() : Retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}