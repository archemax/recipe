package com.example.finalrecipeapplication.presentation.screens.recipe_list

import com.example.finalrecipeapplication.domain.model.RecipeDataClass

data class RecipeListState(
    val isLoading: Boolean = false,
    val recipes: List<RecipeDataClass> = emptyList(),
    val error: String = ""
)
