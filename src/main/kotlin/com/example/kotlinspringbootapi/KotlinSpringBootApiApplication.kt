package com.example.kotlinspringbootapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinSpringBootApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootApiApplication>(*args)
}

@RestController
class MessageController {
    /*
    fun index(@RequestParam("name") name: String) = "Hello, $name!"

    index() is an example of a "single-expression" function (since it contains only one statement), which means that curly braces can be omitted and body specified after `=`
    Return type is infered to String.

    ℹ️ Any controller in the Spring application renders JSON response by default if Jackson library is on the classpath.
    The application responds with a JSON document if the endpoint returns a data structure that can be serialized to JSON.
    */
    // listOf creates a read-only list. (you can use mutableListOf() if you want a mutable one)
    @GetMapping("/")
    fun index() = listOf(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!")
    )
}

/* Message class will be used for data transfer: a list of serialized Message objects will make up the JSON document that the controller is going to respond to the browser request.
The main purpose of data classes in Kotlin is to hold data. Such classes are marked with the data keyword, and some standard functionality and some utility functions are often mechanically derivable from the class structure.

- `val` keyword means that it is read-only
- `var` keyword means that it is mutable
- `String?` is an example of a nullable reference (which means that it can hold the value null)
*/
data class Message(val id: String?, val text: String)