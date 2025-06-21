# randomquotes-hxsc
![License](https://img.shields.io/github/license/marlonlom/randomquotes-hxsc?color=blue)
![Build](https://img.shields.io/github/check-runs/marlonlom/randomquotes-hxsc/main?style=flat&label=Build)
![CodeFactor](https://www.codefactor.io/repository/github/marlonlom/randomquotes-hxsc/badge)

The Random Quotes Hexagon API is a Java microservice web application project for displaying random quotes via **Quotes Hub API**, is a modular and maintainable RESTful service designed using Hexagonal Architecture (also known as Ports and Adapters). Built with Java and Spring Boot, the application cleanly separates core business logic from external systems such as web APIs like **Quotes Hub API**. It delivers random quotes through a well-defined API interface, making it easy to test, extend, and adapt. The project is configured with Maven for dependency management and build automation, ensuring smooth integration and deployment workflows.

## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
  - `java -jar target/randomquotes-hxsc-1.0.0.jar`
  - `mvn spring-boot:run` 

* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2025-01-01T17:42:38.008-05:00  INFO 11012 --- [randomquotes-hxsc] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8081 (http) with context path '/randomquotes-hxsc'
2025-01-01T17:42:38.015-05:00  INFO 11012 --- [randomquotes-hxsc] [  restartedMain] h.r.HexagonalarchRandomquotesApplication : Started HexagonalarchRandomquotesApplication in 1.915 seconds (process running for 2.164)
```

## About the Service

### Features
* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Exception mapping from application exceptions to the right HTTP response with exception details in the body.
* Demonstrates MockMVC test framework with associated libraries.
* All APIs are "self-documented" by Swagger2 using annotations. 


### Endpoints

| Name               | HTTP Method | Response Media type | Url                                 |
|--------------------|-------------|---------------------|-------------------------------------|
| Get a random quote |     GET     | application/json    | /randomquotes-hxsc/v1/quotes/random |

### API Documentation (Swagger/OpenAPI)
This microservice provides interactive API documentation through Swagger UI, powered by OpenAPI specifications. This allows developers to explore available endpoints, understand request/response structures, and even test API calls directly from their browser.

As a prerequisites: before accessing the API documentation, ensure the microservice is running.

#### Open Swagger UI in your Browser
Once the microservice is running, open your web browser and navigate to the following URL:

`http://localhost:8081/randomquotes-hxsc/swagger-ui/index.html`

Alternatively, you might also be able to access the raw OpenAPI JSON specification at:

`http://localhost:8081/randomquotes-hxsc/api-docs`

¿What you'll find?
- Interactive Endpoints: A list of all available API endpoints, grouped by controller or tag.
- Detailed Endpoint Information: For each endpoint, you'll see: HTTP method (GET, POST, PUT, DELETE, etc.),  Request parameters (path variables, query parameters, request body) with their types and descriptions, Expected response codes and their corresponding data models.
- "Try it out" Feature: Most endpoints will have a "Try it out" button that allows you to make API calls directly from the Swagger UI and see the responses.
- Search and Filter: The UI typically provides search and filter capabilities to quickly find specific endpoints.


## License
This application is distributed under the terms of the Apache License (Version 2.0). See the [license](LICENSE) for more information.
