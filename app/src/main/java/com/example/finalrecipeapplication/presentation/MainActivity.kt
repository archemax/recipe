package com.example.finalrecipeapplication.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import com.example.finalrecipeapplication.data.remote.RetrofitLogging
import com.example.finalrecipeapplication.presentation.navigation.NavigationComponent
import com.example.finalrecipeapplication.ui.theme.FinalRecipeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
//        val recipeApi = RetrofitLogging.create()
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val response = recipeApi.getRandomRecipes(
//
//                )
//                Log.d("responseBody", "$response")
//            } catch (e: Exception) {
//            }
//
//        }
    }
}





