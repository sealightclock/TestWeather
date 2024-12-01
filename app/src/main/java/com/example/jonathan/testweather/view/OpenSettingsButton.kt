package com.example.jonathan.testweather.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

const val PACKAGE_NAME = "com.example.jonathan.testweather"

@Composable
// Do not remove this Composable!
fun OpenSettingsButton(context: Context) {
    Button(onClick = {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", PACKAGE_NAME, null)
        }
        context.startActivity(intent)
    }) {
        Text("Open App Settings")
    }
}
