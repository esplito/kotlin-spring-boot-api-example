package com.example.kotlinspringbootapi.controller

import com.example.kotlinspringbootapi.AppProperties
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import org.springframework.web.client.RestTemplate
import kotlin.test.Test

@SpringBootTest
@WireMockTest(httpPort = 8181)
class PokemonControllerWireMockTest {

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var appProperties: AppProperties

    @Test
    fun getwireMockInfo (wireMockRuntimeInfo: WireMockRuntimeInfo) {
        println(wireMockRuntimeInfo.httpBaseUrl + wireMockRuntimeInfo.httpPort)
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
        /*val faultyResponseBody = """
            {
                "results": [
                    {
                        "name": "Charizard",
                        "url": "http://pokemon-mock.local"
                    }
                ]
            }
        """.trimIndent()*/
        stubFor(
            get(urlMatching("/api/v2/pokemon"))
                .willReturn(
                    aResponse()
                        .withStatus( HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(responseBody))
        )

        val response = restTemplate.getForEntity("${appProperties.host}/api/v2/pokemon", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isEqualTo(responseBody)
        // If you want to make the test fail, uncomment this line and the faultyResponseBody above.
        // assertThat(response.body).isEqualTo(faultyResponseBody)

    }
}