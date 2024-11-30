package com.example.jonathan.testweather.model

enum class DataSourceType {
    TEST,
    WEB_BY_RETROFIT
}

class WeatherRepository {
    fun fetchWeatherFromTest(): Weather {
        // TODO: This is a test:
        return Weather(
            "San Jose",
            "20.1"
        )
    }

    fun fetchWeatherFromWebByRetrofit(): Weather {
        // TODO: This is a test:
        return Weather(
            "San Jose",
            "20.1"
        )
    }
}
