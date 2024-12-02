package com.example.jonathan.testweather.model.retrofit

import com.example.jonathan.testweather.model.BASE_URL
import com.example.jonathan.testweather.model.RELATIVE_URL
import com.example.jonathan.testweather.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET(RELATIVE_URL)
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofitApi: RetrofitApi by lazy {
        retrofit.create(RetrofitApi::class.java)
    }
}
