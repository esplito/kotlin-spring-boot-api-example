package com.example.kotlinspringbootapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


/* Message class will be used for data transfer: a list of serialized Message objects will make up the JSON document that the controller is going to respond to the browser request.
The main purpose of data classes in Kotlin is to hold data. Such classes are marked with the data keyword, and some standard functionality and some utility functions are often mechanically derivable from the class structure.

- `val` keyword means that it is read-only
- `var` keyword means that it is mutable
- `String?` is an example of a nullable reference (which means that it can hold the value null)
*/
@Table("MESSAGES")
data class Message(@Id var id: String?, val text: String)