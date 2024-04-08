package com.example.kotlinspringbootapi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties {
    @Value("\${api.pokemon.host}")
    lateinit var host: String
}