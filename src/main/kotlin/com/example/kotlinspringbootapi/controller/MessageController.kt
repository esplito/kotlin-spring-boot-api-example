package com.example.kotlinspringbootapi.controller

import com.example.kotlinspringbootapi.model.Message
import com.example.kotlinspringbootapi.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.NoSuchElementException


@RestController
class MessageController (val service: MessageService) {
    /*
    fun index(@RequestParam("name") name: String) = "Hello, $name!"

    index() is an example of a "single-expression" function (since it contains only one statement), which means that curly braces can be omitted and body specified after `=`
    Return type is infered to String.

    ℹ️ Any controller in the Spring application renders JSON response by default if Jackson library is on the classpath.
    The application responds with a JSON document if the endpoint returns a data structure that can be serialized to JSON.

    listOf creates a read-only list. (you can use mutableListOf() if you want a mutable one)
    */

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> = service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        // Works as both CREATE & UPDATE
        service.save(message)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }

}