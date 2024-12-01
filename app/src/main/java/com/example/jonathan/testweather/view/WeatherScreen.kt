package com.example.jonathan.testweather.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jonathan.testweather.model.DataSourceType
import com.example.jonathan.testweather.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherState by viewModel.weatherState.collectAsState()

    var city by remember { mutableStateOf("Irvine, CA, USA") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter City") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.getData(
            city,
            dataSourceType = DataSourceType.WEB_BY_RETROFIT
            //dataSourceType = DataSourceType.TEST
        ) }) {
            Text("Get Weather")
        }
        Spacer(modifier = Modifier.height(16.dp))
        weatherState?.let { weather ->
            Text(
                text = "Temperature: ${weather.main.temp}°C\n" +
                        "Humidity: ${weather.main.humidity}%\n" +
                        "Condition: ${weather.weather.firstOrNull()?.description.orEmpty()}",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
