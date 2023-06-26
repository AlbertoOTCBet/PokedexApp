package com.example.kotlin.mypokedexapp.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.mypokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.framework.viewmodel.MainViewModel

class MainActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        //setUpRecyclerView(testData())
        //getPokemonList()
        initializeObservers()
        viewModel.getPokemonList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun testData():ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>{
        var result = ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>()

        result.add(com.example.kotlin.mypokedexapp.data.network.model.PokemonBase("bulbasaur", ""))
        result.add(com.example.kotlin.mypokedexapp.data.network.model.PokemonBase("charmander", ""))
        result.add(com.example.kotlin.mypokedexapp.data.network.model.PokemonBase("squirtle", ""))

        return result
    }

   /* private fun getPokemonList() {
        /*CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result:PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
        }*/
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result: PokedexObject? =
                pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.results!!)
            }
        }
    }
    */
    private fun setUpRecyclerView(dataForList:ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        //adapter.PokemonAdapter(dataForList)
        adapter.PokemonAdapter(dataForList,this)
        binding.RVPokemon.adapter = adapter
    }

    private fun initializeObservers(){
        viewModel.pokedexObjectLiveData.observe(this){ poxedexObject ->
            if (poxedexObject != null) {
                setUpRecyclerView(poxedexObject.results)
            }
        }
    }

}
