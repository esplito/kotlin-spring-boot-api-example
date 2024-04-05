package com.example.kotlinspringbootapi.datasource.network

import com.example.kotlinspringbootapi.datasource.PokemonDataSource
import com.example.kotlinspringbootapi.datasource.network.dto.PokemonList
import com.example.kotlinspringbootapi.model.Pokemon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : PokemonDataSource {
    override fun retrievePokemons(): Collection<Pokemon> {
        val response: ResponseEntity<PokemonList> = restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon?limit=151")

        return response.body?.results
            ?: throw IOException("Could not fetch pokemons from the network")
    }
}