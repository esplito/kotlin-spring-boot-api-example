package com.example.kotlinspringbootapi.model

data class PokemonDetail (
    val abilities: List<PokemonAbilityItem>,
    val forms: List<PokemonForm>
)