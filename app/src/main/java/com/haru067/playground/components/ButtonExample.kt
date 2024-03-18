package com.haru067.playground.components

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.wifi.WifiManager
import android.net.wifi.WifiNetworkSpecifier
import android.os.Build
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonExample(modifier: Modifier = Modifier) {
    Row(modifier) {
        Button(
            onClick = {},
            modifier = Modifier
                .border(width = 1.dp, color = Color.Blue)
        ) {
            Text("Default")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .border(width = 1.dp, color = Color.Blue)
                .heightIn(min = 36.dp)
        ) {
            Text("36dp")
        }
        Spacer(modifier = Modifier.width(16.dp))

        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Button(
                onClick = {},
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Blue)
                    .heightIn(min = 36.dp)
            ) {
                Text("36.dp")
            }
        }
    }
}
