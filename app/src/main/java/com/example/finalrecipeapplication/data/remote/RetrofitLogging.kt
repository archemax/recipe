package com.example.finalrecipeapplication.data.remote

import com.example.finalrecipeapplication.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitLogging() {

    companion object {
        private const val BASE_URL = Constants.BASE_URL // Replace with your base URL

        fun create(): RecipeApi {
            val loggingInterceptor = HttpLoggingInterceptor().apply {

                level =
                    HttpLoggingInterceptor.Level.BODY // Set log level to log both request and response bodies
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(RecipeApi::class.java)
        }
    }
}
