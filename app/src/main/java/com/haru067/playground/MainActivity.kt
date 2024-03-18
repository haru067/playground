package com.haru067.playground

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haru067.playground.components.ButtonExample
import com.haru067.playground.components.CarouselExample
import com.haru067.playground.components.FragmentExample
import com.haru067.playground.components.RowExample
import com.haru067.playground.components.TextFieldExample
import com.haru067.playground.components.VerificationCodeInputExample
import com.haru067.playground.components.WifiButton
import com.haru067.playground.ui.theme.PlaygroundTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            PlaygroundTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = "fragment") {
                        composable("profile") { }
                        composable("examples") { Examples() }
                        composable("fragment") { FragmentExample() }
                        /*...*/
                    }
                }
            }
        }
    }
}

@Composable
fun Examples(
    modifier: Modifier = Modifier,
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        CarouselExample(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        ButtonExample(Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(32.dp))
        WifiButton(ssid = "TestWiFi", password = "helloworld")
        Spacer(modifier = Modifier.height(32.dp))
        TextFieldExample(Modifier.padding(8.dp))

        Spacer(modifier = Modifier.height(32.dp))
        VerificationCodeInputExample(Modifier.padding(horizontal = 16.dp))

        Spacer(modifier = Modifier.height(32.dp))
        RowExample(
            Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
    }
}
