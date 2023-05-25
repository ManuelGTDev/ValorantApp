package com.mgtapps.valorantapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/agents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}