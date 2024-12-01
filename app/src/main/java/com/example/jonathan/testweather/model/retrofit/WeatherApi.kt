package com.example.jonathan.testweather.model.retrofit

import com.example.jonathan.testweather.model.RELATIVE_URL
import com.example.jonathan.testweather.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(RELATIVE_URL)
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}
