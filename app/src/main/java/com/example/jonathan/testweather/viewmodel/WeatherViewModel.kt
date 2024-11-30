package com.example.jonathan.testweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testweather.model.WeatherResponse
import com.example.jonathan.testweather.model.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private var apiKey = "cc9a943e9b0082101297ca40b03f1f83"

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.weatherApi.getWeather(city, apiKey)
                _weatherState.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
