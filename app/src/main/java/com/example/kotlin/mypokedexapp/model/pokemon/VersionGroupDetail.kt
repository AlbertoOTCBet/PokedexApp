package com.example.kotlin.mypokedexapp.model.pokemon

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: com.example.kotlin.mypokedexapp.model.pokemon.MoveLearnMethod,
    val version_group: com.example.kotlin.mypokedexapp.model.pokemon.VersionGroup
)