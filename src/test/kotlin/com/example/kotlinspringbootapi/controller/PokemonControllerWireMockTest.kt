package com.example.kotlinspringbootapi.controller

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import kotlin.test.Test

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class PokemonControllerWireMockTest {

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