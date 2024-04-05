package com.example.kotlinspringbootapi.controller

import com.example.kotlinspringbootapi.model.MappedPokemon
import com.example.kotlinspringbootapi.service.PokemonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pokemons")
class PokemonController (private val service: PokemonService) {

    @GetMapping()
    fun getAllPokemons(): List<MappedPokemon> = service.getPokemons();
}