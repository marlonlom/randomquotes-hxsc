package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest;

import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.inbound.GetRandomQuoteUseCase;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.failure.RandomQuoteFailure;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponse;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.mapper.RandomQuoteResponseRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST adapter that exposes an HTTP endpoint for retrieving a random quote.
 *
 * <p>This controller bridges the web layer with the application/business layer by invoking the
 * {@link GetRandomQuoteUseCase} and mapping the domain model to a REST response using {@link
 * RandomQuoteResponseRestMapper}.
 *
 * <p>Follows the principles of Hexagonal Architecture by acting as an input adapter.
 *
 * @see GetRandomQuoteUseCase
 * @see RandomQuoteResponseRestMapper
 * @see RandomQuoteResponse
 * @author marlon.lopez
 * @version 1.0.0
 */
@RestController
@RequestMapping(
        path = "/v1/quotes",
        produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class RandomQuoteRestAdapter {

    /** Use case service that provides the random quote from the domain layer. */
    @Autowired private GetRandomQuoteUseCase getRandomQuoteUseCase;

    /** Mapper to convert domain objects to REST response DTOs. */
    @Autowired private RandomQuoteResponseRestMapper randomQuoteRestMapper;

    /**
     * Handles HTTP GET requests to retrieve a random quote.
     *
     * @return a {@link ResponseEntity} containing the {@link RandomQuoteResponse} and HTTP status
     *     200 (OK)
     */
    @GetMapping(value = "/random")
    @Operation(
            tags = "get-random-quote",
            description = "Retrieves a random quote",
            summary = "Retrieves a random quote",
            responses = {
                @ApiResponse(
                        responseCode = "400",
                        description = "Random quote not found",
                        content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = RandomQuoteFailure.class))
                        })
            })
    public ResponseEntity<RandomQuoteResponse> getRandomQuote() {
        RandomQuote dto = this.getRandomQuoteUseCase.getRandomQuote();
        return new ResponseEntity<>(
                this.randomQuoteRestMapper.toRandomQuoteResponse(dto), HttpStatus.OK);
    }
}
