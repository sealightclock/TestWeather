package com.example.jonathan.testweather.model.retrofit

import com.example.jonathan.testweather.model.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherApi: WeatherApi = retrofit.create(WeatherApi::class.java)
}
