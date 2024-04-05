package com.example.kotlinspringbootapi.datasource

import com.example.kotlinspringbootapi.model.Pokemon

interface PokemonDataSource {
    fun retrievePokemons(): Collection<Pokemon>
}