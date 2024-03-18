package com.haru067.playground.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.net.wifi.WifiNetworkSuggestion
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun WifiButton(ssid: String, password: String) {
    val context = LocalContext.current

    Button(onClick = {
        val suggestion = WifiNetworkSuggestion.Builder()
            .setSsid(ssid)
            .setWpa2Passphrase(password)
            .build()

        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val status = wifiManager.addNetworkSuggestions(
            listOf(
                suggestion,
            )
        )
        if (status != WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS) {
            // do error handling here
            Toast.makeText(context, "status $status", Toast.LENGTH_SHORT).show()
        }

        // Optional (Wait for post connection broadcast to one of your suggestions)
        val intentFilter = IntentFilter(WifiManager.ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION);

        val broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (!intent.action.equals(WifiManager.ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION)) {
                    return;
                }
                // do post connect processing here
                Toast.makeText(context, "broadcast $intent", Toast.LENGTH_SHORT).show()
            }
        }
        context.registerReceiver(broadcastReceiver, intentFilter);
    }) {
        Text("Connect to Wi-Fi")
    }
}
