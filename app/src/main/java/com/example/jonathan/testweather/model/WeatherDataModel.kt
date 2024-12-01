package com.example.jonathan.testweather.model

// !!! Do not rename parameters names inside these data classes, as they are tied to the server names via Gson.

data class WeatherMain(
    val temp: Double,
    val humidity: Int
)

data class WeatherDesc(
    val description: String
)

data class WeatherResponse(
    val main: WeatherMain,
    val weather: List<WeatherDesc>
)
