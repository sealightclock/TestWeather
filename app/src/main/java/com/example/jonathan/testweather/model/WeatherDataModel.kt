package com.example.jonathan.testweather.model

data class Weather0(
    val city: String,
    val temperature: String
)

data class WeatherMain(
    val temp: Double,
    val humidity: Int
)

data class WeatherDesc(
    val description: String
)

data class WeatherResponse(
    val main: WeatherMain,
    val desc: List<WeatherDesc>
)

