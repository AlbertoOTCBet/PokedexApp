package com.example.kotlin.mypokedexapp.model

import com.example.kotlin.mypokedexapp.utils.Constants
import com.example.kotlin.mypokedexapp.gsonFactory
import com.example.kotlin.mypokedexapp.okHttpClient
import retrofit2.Retrofit

object NetworkModuleDI {

    operator fun invoke(): PokemonAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(PokemonAPIService::class.java)
    }
}