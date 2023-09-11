package com.example.finalrecipeapplication.domain.repository

import com.example.finalrecipeapplication.data.dto.RecipeDetailsDto
import com.example.finalrecipeapplication.data.dto.RecipeDto

interface RecipeRepository {

    suspend fun getRecipes(): RecipeDto

    suspend fun getRecipeById(recipeId: String): RecipeDetailsDto
}