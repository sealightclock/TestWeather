package com.example.jonathan.testweather.model

import android.util.Log
import com.example.jonathan.testweather.model.retrofit.RetrofitInstance

private const val TAG = "TW: WeatherRepository"

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val RELATIVE_URL = "weather"

const val MY_APK_KEY = "cc9a943e9b0082101297ca40b03f1f83"

enum class DataSourceType {
    TEST,
    WEB_BY_RETROFIT
}

class WeatherRepository {
    fun fetchWeatherFromTest(): WeatherResponse {
        Log.d(TAG, "fetchWeatherFromTest")

        return WeatherResponse(
            WeatherMain(11.1111, 22),
            listOf(WeatherDesc("Test weather condition"))
        )
    }

    fun fetchWeatherFromWebByRetrofit(city: String): WeatherResponse {
        Log.d(TAG, "fetchWeatherFromWebByRetrofit: city=[$city]")

        // Default value:
        var response = WeatherResponse(
            WeatherMain(0.0, 0),
            emptyList()
        )

        try {
            response = RetrofitInstance.retrofitApi.getWeather(city, MY_APK_KEY)
        } catch (e: Exception) {
            Log.e(TAG, "fetchWeatherFromWebByRetrofit. getWeather: stackTrace=\n" + e.stackTraceToString())
        }

        return response
    }
}
