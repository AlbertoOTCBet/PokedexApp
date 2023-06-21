package com.example.kotlin.mypokedexapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val gsonFactory:GsonConverterFactory = GsonConverterFactory.create()
private val okHttpClient: OkHttpClient = OkHttpClient()
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