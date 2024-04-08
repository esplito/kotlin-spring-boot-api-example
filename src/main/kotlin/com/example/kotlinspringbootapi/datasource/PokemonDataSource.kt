package com.example.kotlinspringbootapi.datasource

import com.example.kotlinspringbootapi.model.Pokemon
import com.example.kotlinspringbootapi.model.PokemonDetail

interface PokemonDataSource {
    fun retrievePokemons(): Collection<Pokemon>
    fun retrievePokemonById(id: String): PokemonDetail
}