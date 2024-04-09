# Notes

This is were I put my notes if I find something interesting in documentation or while experimenting.

## Kotlin - Syntax

- When prefixing an argument with * you are using the spread operator. Example in the `main()` function: `*args`.

## Run requests locally directly in IntelliJ IDEA

You can create a `requests.http` file (there's an example file of this in the project) and add the requests you want to run.
You get a green "Run" icon next to them.

I followed the [instructions here](https://kotlinlang.org/docs/jvm-spring-boot-add-db-support.html#add-messages-to-database-via-http-request).

## Learn more about Kotlin 📚

The tutorial ended with a link to a [PDF that can be used for a personal development map when learning Kotlin](https://resources.jetbrains.com/storage/products/kotlin/docs/Kotlin_Language_Features_Map.pdf).

## Automated testing 🧪

I will look into this tutorial: https://kotlinlang.org/docs/jvm-test-using-junit.html
I've also looked at this Youtube playlist: https://www.youtube.com/playlist?list=PL6gx4Cwl9DGDPsneZWaOFg0H2wsundyGr

The structure of the API based on the Youtube playlist:
![Illustration of web layer -> service layer -> data source -> data layer](./structure-kotlin-spring-boot-api.png)

## Mocking libraries 🙌
- Tested https://mockk.io/ & built-in mockMvc
- Testing https://wiremock.org/docs/ for stubbing external requests (but it is not so easy to get working as the others)

## Issues 🚨
1. There's a lack of good documentation for configuring Wiremock with Kotlin + Spring Boot (and JUnit 5). I've gone through several community-made articles/guides to try and find a good solution, but have failed so far. 

## Highlights
1. I like how much "Java boilerplate" that Kotlin seems to have removed. Defining classes and functions is a joy and feels more similar to what I'm used to in the Javascript world. 😊
2. It was easy to get started with the basics just by just following Kotlin's own docs. 