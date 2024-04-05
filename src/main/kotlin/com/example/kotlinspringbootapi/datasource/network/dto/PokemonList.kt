package com.example.kotlinspringbootapi.datasource.network.dto

import com.example.kotlinspringbootapi.model.Pokemon

data class PokemonList (val results: Collection<Pokemon>)