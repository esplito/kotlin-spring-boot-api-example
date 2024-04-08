package com.example.kotlinspringbootapi.datasource.mock

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import com.example.kotlinspringbootapi.model.*
import org.springframework.stereotype.Repository

@Repository
class MockPokemonDataSource : PokemonDataSource {

    val pokemons = listOf(Pokemon("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"), Pokemon("Charmander", "https://pokeapi.co/api/v2/pokemon/4/"))
    override fun retrievePokemons(): Collection<Pokemon> = pokemons

    val pokemonDetails = PokemonDetail(abilities = listOf(PokemonAbilityItem(PokemonAbility("overgrow", "https://pokeapi.co/api/v2/ability/65/"), is_hidden = false, slot = 1)), forms = listOf(PokemonForm("bulbasaur", "https://pokeapi.co/api/v2/pokemon-form/1/")))
    override fun retrievePokemonById(id: String): PokemonDetail = pokemonDetails
}