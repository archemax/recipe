package com.example.finalrecipeapplication.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.navigation.compose.rememberNavController

import com.example.finalrecipeapplication.presentation.navigation.NavigationComponent
import com.example.finalrecipeapplication.presentation.screens.main_user_screen.MainUserScreen
import com.example.finalrecipeapplication.ui.theme.FinalRecipeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalRecipeApplicationTheme {
                NavigationComponent()
            }
        }
    }
}




