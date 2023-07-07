package com.example.kotlin.mypokedexapp.framework.adapters.viewHolders

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.databinding.InfoActivityBinding
import com.example.kotlin.mypokedexapp.databinding.ItemPokemonBinding
import com.example.kotlin.mypokedexapp.domain.PokemonInfoRequirement
import com.example.kotlin.mypokedexapp.framework.views.activities.PokemonDetailActivity
import com.example.kotlin.mypokedexapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var bindingInfo : InfoActivityBinding
    fun bind(item: PokemonBase, context:Context){
        binding.TVName.text = item.name
        getPokemonInfo(item.url,binding.IVPhoto,context)
        binding.llPokemo.setOnClickListener {

            passViewGoToPokemonDetail(item.url,context)
        }
    }

    private fun getPokemonInfo(url:String, imageView:ImageView,context:Context){
        //"https://pokeapi.co/api/v2/pokemon/23/"
        var pokemonStringNumber:String = url.replace("https://pokeapi.co/api/v2/pokemon/","")
        pokemonStringNumber = pokemonStringNumber.replace("/","")
        val pokemonNumber:Int = Integer.parseInt(pokemonStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: Pokemon? = pokemonInfoRequirement(pokemonNumber)
            CoroutineScope(Dispatchers.Main).launch {
                //todo:Agregar imagen
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }

    private fun passViewGoToPokemonDetail(url: String,context:Context){
        var intent: Intent = Intent(context, PokemonDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra(Constants.URL_POKEMON,url)
        context.startActivity(intent)
    }

}