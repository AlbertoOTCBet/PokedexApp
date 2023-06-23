package com.example.kotlin.mypokedexapp

import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

private val gsonFactory:GsonConverterFactory = GsonConverterFactory.create()
private val okHttpClient: OkHttpClient = OkHttpClient()
