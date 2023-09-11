package com.example.finalrecipeapplication.domain.use_case.get_recipes_list

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.finalrecipeapplication.common.Resource
import com.example.finalrecipeapplication.domain.model.RecipeDataClass
import com.example.finalrecipeapplication.domain.model.toRecipeDataClass
import com.example.finalrecipeapplication.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<RecipeDataClass>>> =
        flow<Resource<List<RecipeDataClass>>> {
            try {
                emit(Resource.Loading()) //show progrees bar

                val recipesDto = repository.getRecipes()
                val recipesList = listOf(recipesDto.toRecipeDataClass())

                emit(Resource.Success(recipesList))

            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
            } catch (e: IOException) {
                emit(Resource.Error("No connection to server... check your internet connection"))
            }
        }
}