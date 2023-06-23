package com.example.kotlin.mypokedexapp.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl") val diamond_pearl: com.example.kotlin.mypokedexapp.model.pokemon.DiamondPearl,
    @SerializedName("heartgold-soulsilver") val heartgold_soulsilver: com.example.kotlin.mypokedexapp.model.pokemon.HeartgoldSoulsilver,
    val platinum: com.example.kotlin.mypokedexapp.model.pokemon.Platinum
)