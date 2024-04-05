package com.example.kotlinspringbootapi.model

data class Pokemon (
    // If you have renamed these to something else than the external api you can use @JsonProperty("name_of_propery_in_api_response")
    val name: String,
    val url: String,
)