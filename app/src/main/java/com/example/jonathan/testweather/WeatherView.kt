package com.example.jonathan.testweather

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun WeatherView(weatherViewModel: WeatherViewModel) {
    val weather = weatherViewModel.weather.observeAsState().value
    Column {
        weather?.let {
            Text (
                text = weather.city
            )
        }

        weather?.let {
            Text (
                text = it.temperature
            )
        }
    }
}