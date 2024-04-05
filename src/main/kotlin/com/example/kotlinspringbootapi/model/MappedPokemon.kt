package com.example.kotlinspringbootapi.model

import java.util.*
import kotlin.reflect.full.memberProperties

data class MappedPokemon (
    val name: String,
    val url: String,
    val id: String
)

fun Pokemon.toMappedPokemon() = MappedPokemon(
    name = name,
    url = url,
    id = url.substringBeforeLast("/").substringAfterLast("/")
)