package com.example.finalrecipeapplication.presentation

import MySplashScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalrecipeapplication.presentation.screens.main_user_screen.MainUserScreen
import com.example.finalrecipeapplication.presentation.screens.recipe_list.RecipeListViewModel
import com.example.finalrecipeapplication.ui.theme.FinalRecipeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalRecipeApplicationTheme {
                val navController = rememberNavController()
                val viewModel: RecipeListViewModel = hiltViewModel()

                NavHost(navController, startDestination = "splash") {
                    composable("splash") {
                        // Display the splash screen
                        MySplashScreen(modifier = Modifier.fillMaxSize())
                        navController.navigate("main")
                    }
                    composable("main") {
                        MainUserScreen(navController = navController,viewModel )
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent() {


}

