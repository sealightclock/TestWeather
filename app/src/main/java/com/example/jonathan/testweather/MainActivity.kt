package com.example.jonathan.testweather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testweather.model.DataSourceType
import com.example.jonathan.testweather.ui.theme.TestWeatherTheme
import com.example.jonathan.testweather.view.WeatherView
import com.example.jonathan.testweather.viewmodel.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "TW: MainActivity"

class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        // Update ViewModel:
        weatherViewModel.viewModelScope.launch(Dispatchers.IO) {
            weatherViewModel.getData(DataSourceType.TEST)
        }

        // Observe ViewModel changes (for debugging purposes only):
        weatherViewModel.weather.observe(this) {
            Log.d(TAG, "onCreate: viewModel.users.observe: $it")
        }

        setContent {
            TestWeatherTheme {
                WeatherView(weatherViewModel)
            }
        }
    }
}
