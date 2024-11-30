package com.example.jonathan.testweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jonathan.testweather.model.DataSourceType
import com.example.jonathan.testweather.model.Weather0
import com.example.jonathan.testweather.model.WeatherRepository

class Weather0ViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private var _weather0 = MutableLiveData<Weather0>()
    var weather0: LiveData<Weather0> = _weather0

    suspend fun getData(dataSourceType: DataSourceType) {
        val newWeather = when (dataSourceType) {
            DataSourceType.TEST -> repository.fetchWeatherFromTest()
            DataSourceType.WEB_BY_RETROFIT -> repository.fetchWeatherFromWebByRetrofit()
        }

        _weather0.postValue(newWeather)
    }
}
