package com.example.kotlinspringbootapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@SpringBootApplication
class KotlinSpringBootApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootApiApplication>(*args)
}

/* Message class will be used for data transfer: a list of serialized Message objects will make up the JSON document that the controller is going to respond to the browser request.
The main purpose of data classes in Kotlin is to hold data. Such classes are marked with the data keyword, and some standard functionality and some utility functions are often mechanically derivable from the class structure.

- `val` keyword means that it is read-only
- `var` keyword means that it is mutable
- `String?` is an example of a nullable reference (which means that it can hold the value null)
*/
data class Message(val id: String?, val text: String)

/*
 `val db: JdbcTemplate` is the constructor's argument.
According to the Kotlin convention, if the last parameter of a function is a function, then a lambda expression passed as the corresponding argument can be placed outside the parentheses.
Such syntax is also known as trailing lambda.

_ is used to replace the name of a parameter that is unused.
 */
@Service
class MessageService(val db: JdbcTemplate) {
    fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message) {
        /* we are using the "Elvis operator" ?: here.
        (if-not-null-else shorthand): https://kotlinlang.org/docs/null-safety.html#elvis-operator
        If the expression to the left of ?: is not null, the Elvis operator returns it; otherwise, it returns the expression to the right.
        Note that the expression on the right-hand side is evaluated only if the left-hand side is null.
        */
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
                "insert into messages values (?, ?)",
                id, message.text
        )
    }
}

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
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}
