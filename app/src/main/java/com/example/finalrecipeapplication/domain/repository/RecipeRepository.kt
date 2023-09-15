package com.example.finalrecipeapplication.domain.repository

import com.example.finalrecipeapplication.data.dto.RecipeDetailsDto
import com.example.finalrecipeapplication.data.dto.RecipeDto
import com.example.finalrecipeapplication.data.dto.RecipesDtoSearchResult

interface RecipeRepository {

    suspend fun getRecipes(): RecipeDto

    suspend fun getRecipeById(recipeId: String): RecipeDetailsDto

    suspend fun getRecipesBySearch(query:String): RecipesDtoSearchResult
}