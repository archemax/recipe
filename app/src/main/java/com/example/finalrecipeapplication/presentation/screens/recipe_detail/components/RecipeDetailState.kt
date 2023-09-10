package com.example.finalrecipeapplication.presentation.screens.recipe_detail.components

import com.example.finalrecipeapplication.domain.model.RecipeDataClass
import com.example.finalrecipeapplication.domain.model.RecipeDetailDataClass

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val recipes: RecipeDetailDataClass? = null,
    val error: String = ""
)
