package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.navigation.NavigationLabApp
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.theme.ModulNavCompose_245150200111026MuhammadRamadhikaEsanofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationLabApp()
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
    ModulNavCompose_245150200111026MuhammadRamadhikaEsanofTheme {
        Greeting("Android")
    }
}