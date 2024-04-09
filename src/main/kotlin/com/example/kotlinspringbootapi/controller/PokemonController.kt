package com.example.kotlinspringbootapi.controller

import com.example.kotlinspringbootapi.model.MappedPokemon
import com.example.kotlinspringbootapi.model.PokemonDetail
import com.example.kotlinspringbootapi.service.PokemonService
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/api/pokemons")
class PokemonController (private val service: PokemonService) {

    @ExceptionHandler(HttpClientErrorException::class)
    fun handleNotFound(e: HttpClientErrorException.NotFound): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping()
    fun getAllPokemons(): List<MappedPokemon> = service.getPokemons();

    @ApiResponses(
        value = arrayOf(
            ApiResponse(responseCode = "200", description = "OK"),
            ApiResponse(responseCode = "404", description = "Pokemon not Found"),
        )
    )
    @GetMapping("/{id}")
    fun getPokemonById(@PathVariable id: String): PokemonDetail = service.getPokemonById(id)
}