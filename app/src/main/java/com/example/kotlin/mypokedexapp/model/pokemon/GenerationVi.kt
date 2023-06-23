package com.example.kotlin.mypokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire") val omegaruby_alphasapphire: com.example.kotlin.mypokedexapp.model.pokemon.OmegarubyAlphasapphire,
    @SerializedName("x-y") val x_y: com.example.kotlin.mypokedexapp.model.pokemon.XY
)