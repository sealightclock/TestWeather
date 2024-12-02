package com.example.jonathan.testweather

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.jonathan.testweather.ui.theme.TestWeatherTheme
import com.example.jonathan.testweather.view.MultiPermissionScreen
import com.example.jonathan.testweather.viewmodel.WeatherViewModel

private const val TAG = "TW: MainActivity"

val permissions = listOf(
    android.Manifest.permission.ACCESS_FINE_LOCATION
)

class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)

        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        setContent {
            TestWeatherTheme {
                MultiPermissionScreen(permissions,this, weatherViewModel)
            }
        }
    }
}
