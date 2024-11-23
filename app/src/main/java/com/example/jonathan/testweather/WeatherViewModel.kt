package com.example.jonathan.testweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private var _weather = MutableLiveData<Weather>()
    var weather: LiveData<Weather> = _weather

    suspend fun loadDataFromRepository() {
        _weather.postValue(repository.getWeatherFromWeb())
    }
}