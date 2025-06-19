package dev.marlonlom.demos.hexagonalarch.randomquotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Main entry point for the Random Quotes Spring Boot application.
 * 
 * @author marlon.lopez
 * @version 1.0.0
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Random Quotes Hexagon API", version = "1.0.0", description = "API Design for Random Quotes: An Exploration of Hexagonal Architecture"))
public class HexagonalarchRandomquotesApplication {

	/**
	 * Starts the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HexagonalarchRandomquotesApplication.class, args);
	}

}
