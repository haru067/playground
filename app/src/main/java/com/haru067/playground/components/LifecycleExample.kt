package com.haru067.playground.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.LifecycleResumeEffect

@Composable
fun LifecycleExample(
    modifier: Modifier = Modifier,
    navigateToProfile: () -> Unit,
) {
    val currentState by LocalLifecycleOwner.current.lifecycle.currentStateFlow.collectAsState()
    LaunchedEffect(currentState) {
        Log.d("LifecycleExample", "currentState: $currentState")

    }
    Column(modifier) {
        Text("LifecycleExample")
        Button(onClick = navigateToProfile) {
            Text("Navigate to Profile")
        }
    }
}
