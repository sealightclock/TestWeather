package com.example.jonathan.testweather

data class Weather(val city: String, val temperature: String)

class WeatherRepository {
    fun getWeatherFromWeb(): Weather {
        // TODO: This is a test:
        return Weather(
            "San Jose",
            "20.1"
        )
    }
}
