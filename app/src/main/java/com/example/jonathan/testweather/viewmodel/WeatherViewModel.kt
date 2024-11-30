package com.example.jonathan.testweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jonathan.testweather.model.DataSourceType
import com.example.jonathan.testweather.model.Weather
import com.example.jonathan.testweather.model.WeatherRepository

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private var _weather = MutableLiveData<Weather>()
    var weather: LiveData<Weather> = _weather

    suspend fun getData(dataSourceType: DataSourceType) {
        val newWeather = when (dataSourceType) {
            DataSourceType.TEST -> repository.fetchWeatherFromTest()
            DataSourceType.WEB_BY_RETROFIT -> repository.fetchWeatherFromWebByRetrofit()
        }

        _weather.postValue(newWeather)
    }
}
