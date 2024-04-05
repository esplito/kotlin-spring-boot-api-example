package com.example.kotlinspringbootapi.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MockPokemonDataSourceTest {

    private val mockDataSource = MockPokemonDataSource()

    @Test
    fun `should provide a collection of pokemons`() {
        // when
        val pokemons = mockDataSource.retrievePokemons()

        // then
        assertThat(pokemons).isNotEmpty()
    }

    @Test
    fun `should provide some mock data`() {
        // when
        val pokemons = mockDataSource.retrievePokemons()

        // then
        assertThat(pokemons).allMatch { it.name.isNotBlank() }
        assertThat(pokemons).allMatch { it.url.isNotBlank() }

    }
}