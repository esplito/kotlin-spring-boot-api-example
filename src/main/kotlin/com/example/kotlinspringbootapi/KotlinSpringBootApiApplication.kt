package com.example.kotlinspringbootapi


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

// @OpenAPIDefinition(servers = [Server(url = "/kotlin-example-api", description = "This API is built with Kotlin & Spring Boot and has some example CRUD operations in messages-endpoints. The Pokemon-endpoints are used for showing an example of integrating towards an external API.")])
@SpringBootApplication
class KotlinSpringBootApiApplication {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootApiApplication>(*args)
}

