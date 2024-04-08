package com.example.kotlinspringbootapi.controller

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

import kotlin.test.Test


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

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class PokemonControllerTestWithMocks {

    val wireMockServer = WireMockServer(wireMockConfig().port(8080))

    @Autowired
    lateinit var mockMvc: MockMvc

    @BeforeAll
    fun beforeAll() {
        wireMockServer.start()
    }
    @AfterAll
    fun afterAll() {
        wireMockServer.stop()
    }
    @BeforeEach
    fun beforeEach() {
        wireMockServer.resetRequests()
    }


    private fun stubResponse(url: String, responseBody: String, responseStatus: Int = HttpStatus.OK.value()) {
        wireMockServer.stubFor(
            get(urlMatching(url))
                .willReturn(
                aResponse()
                    .withStatus(responseStatus)
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withBody(responseBody))
        )
    }

    @Test
    fun `returns mocked pokemon response using WireMock`() {
        val responseBody = """
            {
                "results": [
                    {
                        "name": "Charmander",
                        "url": "http://pokemon-mock.local"
                    }
                ]
            }
        """.trimIndent()
        stubResponse(url = "/api/pokemons", responseBody)


        // TODO: Fix wiremock stubbing so that this test passes :)
        mockMvc
            .get("/api/pokemons")
            .andDo { print() }
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON_VALUE)} }
            .andExpect { jsonPath("$.results.[0].name") { value("Charmander") } }

    }
}