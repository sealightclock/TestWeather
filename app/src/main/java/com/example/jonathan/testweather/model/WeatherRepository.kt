package com.example.jonathan.testweather.model

enum class DataSourceType {
    TEST,
    WEB_BY_RETROFIT
}

class WeatherRepository {
    fun fetchWeatherFromTest(): Weather0 {
        // TODO: This is a test:
        return Weather0(
            "San Jose",
            "20.1"
        )
    }

    fun fetchWeatherFromWebByRetrofit(): Weather0 {
        // TODO: This is a test:
        return Weather0(
            "San Jose",
            "20.1"
        )
    }
}
