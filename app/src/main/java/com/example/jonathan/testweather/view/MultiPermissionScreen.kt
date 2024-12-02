package com.example.jonathan.testweather.view

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jonathan.testweather.viewmodel.WeatherViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

// This is to make sure that permissions can still be granted
private var isPermissionsDialogLaunched = false

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
// Do not remove context!
fun MultiPermissionScreen(permissions: List<String>, context: Context, viewModel: WeatherViewModel) {
    val multiplePermissionsState = rememberMultiplePermissionsState(permissions)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            multiplePermissionsState.allPermissionsGranted -> {
                Text("allPermissionsGranted")
                Spacer(modifier = Modifier.height(8.dp))
                // Go to the next screen:
                WeatherScreen(viewModel)
            }
            multiplePermissionsState.shouldShowRationale -> {
                Text("shouldShowRationale")
                Spacer(modifier = Modifier.height(8.dp))
                // Ask user for permissions:
                Button(onClick = {
                    isPermissionsDialogLaunched = true
                    multiplePermissionsState.launchMultiplePermissionRequest()
                }) {
                    Text("Request Permissions")
                }
            }
            else -> {
                if (!isPermissionsDialogLaunched) {
                    // Not requested yet.
                    Text("Not requested yet.")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Ask user for permissions:
                    Button(onClick = {
                        isPermissionsDialogLaunched = true
                        multiplePermissionsState.launchMultiplePermissionRequest()
                    }) {
                        Text("Request Permissions")
                    }
                } else {
                    // Permanently denied.
                    Text("Permanently denied. Use Settings app to allow them.")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Direct the user to the Settings page:
                    OpenSettingsButton(context)
                }
            }
        }
    }
}
