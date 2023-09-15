package com.example.finalrecipeapplication.di

import com.example.finalrecipeapplication.common.Constants
import com.example.finalrecipeapplication.data.remote.RecipeApi
import com.example.finalrecipeapplication.data.repository.RecipeRepositoryImpl
import com.example.finalrecipeapplication.domain.repository.RecipeRepository
import com.example.finalrecipeapplication.domain.use_case.get_recipe_by_search.GetRecipeBySearchUseCase
import com.example.finalrecipeapplication.domain.use_case.get_recipes_list.GetRecipesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(api: RecipeApi): RecipeRepository{
        return RecipeRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideGetRecipeBySearchUseCase(
        repository: RecipeRepository
    ): GetRecipeBySearchUseCase {
        return GetRecipeBySearchUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetRecipesUseCase(
        repository: RecipeRepository
    ): GetRecipesUseCase {
        return GetRecipesUseCase(repository)
    }


}