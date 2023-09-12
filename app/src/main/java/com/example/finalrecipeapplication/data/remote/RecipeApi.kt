package com.example.finalrecipeapplication.data.remote

import com.example.finalrecipeapplication.common.Constants
import com.example.finalrecipeapplication.data.dto.RecipeDetailsDto
import com.example.finalrecipeapplication.data.dto.RecipeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {

    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("number") number:Int = 20
    ): RecipeDto

    @GET("/recipes/{id}/information")
    suspend fun getRecipeById(
        @Path("id") id: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): RecipeDetailsDto
}