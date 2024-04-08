package com.example.kotlinspringbootapi.service

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import com.example.kotlinspringbootapi.model.toMappedPokemon
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*
import java.util.stream.Collectors

class PokemonServiceTest {
    
    private val dataSource: PokemonDataSource = mockk(relaxed = true, relaxUnitFun = true)
    /*
    We use relaxed true instead of

    // given
    every { dataSource.retrievePokemons() } returns emptyList()
    * */
    private val pokemonService = PokemonService(dataSource);

    // TODO: fix the failing test case
    @Test
    fun `should call its data source to retrieve pokemons`() {
        // when
        pokemonService.getPokemons() // This test case fails due to "class java.lang.Object cannot be cast to class java.util.List (java.lang.Object and java.util.List are in module java.base of loader 'bootstrap')"
        // then
        verify(exactly = 1) { dataSource.retrievePokemons() }

    }
    @Test
    fun `should call its data source to retrieve pokemon by id`() {
        // when
        pokemonService.getPokemonById("1")
        // then
        verify(exactly = 1) { dataSource.retrievePokemonById("1") }

    }
}