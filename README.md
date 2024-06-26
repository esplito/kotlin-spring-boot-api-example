# Kotlin Spring Boot API

In this repository I'm playing around with Kotlin & Spring Boot to get a feel for how it is to develop APIs using those technologies.

I'm initially following [Kotlin's official guide](https://kotlinlang.org/docs/jvm-get-started-spring-boot.html) for setting this up.

## Checklist

I have checklist of things that I want to try. See below.

- [x] Create a RESTful web service with H2 Database 
- [x] Add endpoint for CREATE 
- [x] Add endpoint for READ (fetch all or by id)
- [x] Add endpoint for UPDATE
- [X] Add endpoint for DELETE
- [x] Add error handling (404 Not Found added)
- [x] Generate Swagger with OpenAPI
- [x] Add unit testing (Testing with Mockk in PokemonService)
- [x] Add integration testing (Testing with SpringBootTest)
- [x] Explore API mocking in integration tests (when calling external service)

## Notes

You can find [my notes here](./NOTES.md).

## Swagger

You can find the swagger at http://localhost:8080/swagger-ui/index.html#/ after starting the API.

![Screenshot of the API's Swagger UI in a browser](./swagger-kotlin-api.png)