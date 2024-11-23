package com.example.jonathan.testweather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jonathan.testweather.ui.theme.TestWeatherTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "TW: MainActivity"

class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        // Update ViewModel:
        weatherViewModel.viewModelScope.launch(Dispatchers.IO) {
            weatherViewModel.loadDataFromRepository()
        }

        // Observe ViewModel changes (for debugging purposes only):
        weatherViewModel.weather.observe(this) {
            Log.d(TAG, "onCreate: viewModel.users.observe: $it")
        }


        setContent {
            TestWeatherTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/

                WeatherView(weatherViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestWeatherTheme {
        Greeting("Android")
    }
}
