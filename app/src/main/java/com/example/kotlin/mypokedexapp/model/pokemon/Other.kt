package com.example.kotlin.mypokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: com.example.kotlin.mypokedexapp.model.pokemon.DreamWorld,
    val home: com.example.kotlin.mypokedexapp.model.pokemon.Home,
    @SerializedName("official-artwork") val official_artwork: com.example.kotlin.mypokedexapp.model.pokemon.OfficialArtwork
)