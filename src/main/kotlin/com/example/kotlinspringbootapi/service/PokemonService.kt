package com.example.kotlinspringbootapi.service

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import com.example.kotlinspringbootapi.model.MappedPokemon
import com.example.kotlinspringbootapi.model.Pokemon
import com.example.kotlinspringbootapi.model.PokemonDetail
import com.example.kotlinspringbootapi.model.toMappedPokemon
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class PokemonService (@Qualifier("network") val dataSource: PokemonDataSource) {
    fun getPokemons(): List<MappedPokemon> = dataSource.retrievePokemons().stream().map { it.toMappedPokemon() }.collect(Collectors.toList())

    fun getPokemonById(id: String): PokemonDetail = dataSource.retrievePokemonById(id)
}