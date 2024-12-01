package com.example.jonathan.testweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testweather.model.MY_APK_KEY
import com.example.jonathan.testweather.model.WeatherResponse
import com.example.jonathan.testweather.model.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun getData(city: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.weatherApi.getWeather(city, MY_APK_KEY)
                _weatherState.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
