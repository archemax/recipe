package com.example.finalrecipeapplication.data.repository

import android.util.Log
import com.example.finalrecipeapplication.data.dto.RecipeDetailsDto
import com.example.finalrecipeapplication.data.dto.RecipeDto
import com.example.finalrecipeapplication.data.dto.RecipesDtoSearchResult
import com.example.finalrecipeapplication.data.remote.RecipeApi
import com.example.finalrecipeapplication.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {
    override suspend fun getRecipes(): RecipeDto {
        return api.getRandomRecipes()
    }

    override suspend fun getRecipeById(recipeId: String): RecipeDetailsDto {
        return api.getRecipeById(recipeId)
    }

    override suspend fun getRecipesBySearch(query: String): RecipesDtoSearchResult {
        val response = api.getRecipesBySearch()
        Log.d("repoLog", "$response")
        return response

    }


}