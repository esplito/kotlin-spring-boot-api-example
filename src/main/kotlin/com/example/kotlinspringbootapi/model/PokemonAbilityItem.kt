package com.example.kotlinspringbootapi.model

data class PokemonAbilityItem (
    val ability: PokemonAbility,
    val is_hidden: Boolean,
    val slot: Int
)