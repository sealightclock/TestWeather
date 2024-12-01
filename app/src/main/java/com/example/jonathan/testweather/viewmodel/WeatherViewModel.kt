package com.example.jonathan.testweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testweather.model.DataSourceType
import com.example.jonathan.testweather.model.WeatherRepository
import com.example.jonathan.testweather.model.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private val _weatherState = MutableStateFlow<WeatherResponse?>(null)
    val weatherState: StateFlow<WeatherResponse?> = _weatherState

    fun getData(city: String, dataSourceType: DataSourceType) {
        viewModelScope.launch {
            val response = when (dataSourceType) {
                DataSourceType.TEST -> { repository.fetchWeatherFromTest() }
                DataSourceType.WEB_BY_RETROFIT -> { repository.fetchWeatherFromWebByRetrofit(city) }
            }

            _weatherState.value = response
        }
    }
}
