package com.example.kotlinspringbootapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestPropertySource

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

import kotlin.test.Test

// These tests will only pass if you change `api.pokemon.url` to "https://pokeapi.co" in test/application.properties

// Integration test that will set up application context. Beware, this can be expensive.
@SpringBootTest
@AutoConfigureMockMvc
class PokemonControllerTest {

    // No real http requests will be done in the test.
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all pokemons`() {
        // when/then
        mockMvc.get("/api/pokemons")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].name") {
                    value("bulbasaur")
                }
                jsonPath("$[0].id") {
                    value("1")
                }
                jsonPath("$[1].name") {
                    value("ivysaur")
                }
                jsonPath("$[1].id") {
                    value("2")
                }
            }
    }

    @Test
    fun `should return the pokemon with the given id`() {
        mockMvc.get("/api/pokemons/1")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.forms[0].name") {
                    value("bulbasaur")
                }
                jsonPath("$.abilities.[0].ability.name") {
                    value("overgrow")
                }
            }

    }

}