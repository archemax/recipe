package com.example.finalrecipeapplication.presentation

import MySplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalrecipeapplication.presentation.screens.main_user_screen.MainUserScreen
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
                        navController.navigate("main")

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

    MainUserScreen()
}

