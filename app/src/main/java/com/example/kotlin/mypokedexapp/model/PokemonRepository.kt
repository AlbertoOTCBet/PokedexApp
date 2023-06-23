package com.example.kotlin.mypokedexapp.model

import com.example.kotlin.mypokedexapp.model.NetworkModuleDI
import com.example.kotlin.mypokedexapp.model.PokedexObject
import com.example.kotlin.mypokedexapp.model.PokemonAPIService
import com.example.kotlin.mypokedexapp.model.pokemon.Pokemon

class PokemonRepository {

    private lateinit var api: PokemonAPIService

    suspend fun getPokemonList(limit:Int): PokedexObject?{
        //todo: Inicializar variable api
        api = NetworkModuleDI()
        return try{
            api.getPokemonList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getPokemonInfo(numberPokemon:Int): com.example.kotlin.mypokedexapp.model.pokemon.Pokemon? {
        //todo: Inicializar variable api
        api = NetworkModuleDI()
        return try{
            api.getPokemonInfo(numberPokemon)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}