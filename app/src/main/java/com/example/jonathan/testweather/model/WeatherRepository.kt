package com.example.jonathan.testweather.model

import com.example.jonathan.testweather.model.retrofit.RetrofitInstance

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val RELATIVE_URL = "weather"

const val MY_APK_KEY = "cc9a943e9b0082101297ca40b03f1f83"

enum class DataSourceType {
    TEST,
    WEB_BY_RETROFIT
}

class WeatherRepository {
    fun fetchWeatherFromTest(): WeatherResponse {
        return WeatherResponse(
            Main(11.1111, 22), emptyList()
        )
    }

    suspend fun fetchWeatherFromWebByRetrofit(city: String): WeatherResponse {
        // Default value:
        var response = WeatherResponse(
            Main(0.0, 0),
            emptyList()
        )

        try {
            response = RetrofitInstance.weatherApi.getWeather(city, MY_APK_KEY)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return response
    }
}
