package com.example.kotlinspringbootapi.datasource.mock

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import com.example.kotlinspringbootapi.model.Pokemon
import org.springframework.stereotype.Repository

@Repository
class MockPokemonDataSource : PokemonDataSource {

    val pokemons = listOf(Pokemon("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"), Pokemon("Charmander", "https://pokeapi.co/api/v2/pokemon/4/",))
    override fun retrievePokemons(): Collection<Pokemon> = pokemons
}