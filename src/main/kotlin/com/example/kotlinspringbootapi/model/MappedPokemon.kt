package com.example.kotlinspringbootapi.model

data class MappedPokemon (
    val name: String,
    val url: String,
    val id: String
)


// Inspired by the guide here: https://www.baeldung.com/kotlin/data-objects
fun Pokemon.toMappedPokemon() = MappedPokemon(
    name = name,
    url = url,
    id = url.substringBeforeLast("/").substringAfterLast("/")
)