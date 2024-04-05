package com.example.kotlinspringbootapi.service

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PokemonServiceTest {
    
    private val dataSource: PokemonDataSource = mockk(relaxed = true)
    /*
    We use relaxed true instead of

    // given
    every { dataSource.retrievePokemons() } returns emptyList()
    * */
    private val pokemonService = PokemonService(dataSource);

    // TODO: Fix this test case after adding mapper to Pokemon
    @Test
    fun `should call its data source to retrieve pokemons`() {
        // when
        pokemonService.getPokemons()
        // then
        verify(exactly = 1) { dataSource.retrievePokemons() }

    }
}