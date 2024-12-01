package com.example.jonathan.testweather.model

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Weather(
    val description: String
)

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

