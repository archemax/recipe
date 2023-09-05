package com.example.finalrecipeapplication.presentation

import MySplashScreen
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalrecipeapplication.ui.theme.FinalRecipeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalRecipeApplicationTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "splash") {
                    composable("splash") {
                        // Display the splash screen
                        MySplashScreen(modifier = Modifier.fillMaxSize())
                        Handler(Looper.getMainLooper()).postDelayed({
                            navController.navigate("main")
                        }, 2000)
                    }
                    composable("main") {

                        MainContent()
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent() {

    Text(
        text = "Welcome to My App!",
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(16.dp)
    )
}

