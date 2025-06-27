/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.failure;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.exception.RandomQuoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling {@link RandomQuoteNotFound} exceptions thrown by the
 * application. <br>
 * <br>
 * Intercepts the exception and returns a standardized JSON error response with HTTP status {@code
 * 400 Bad Request}.
 *
 * @author marlonlom
 * @version 1.0.0
 */
@RestControllerAdvice
public class RandomQuoteNotFoundAdvice {

    /**
     * Handles {@link RandomQuoteNotFound} exceptions and maps them to a {@link RandomQuoteFailure}
     * error response.
     *
     * @param exception the exception that was thrown when a random quote was not found
     * @return a {@link RandomQuoteFailure} object containing the error message
     */
    @ExceptionHandler(
            exception = RandomQuoteNotFound.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RandomQuoteFailure randomQuoteNotFoundHandler(RandomQuoteNotFound exception) {
        return RandomQuoteFailure.builder().error(exception.getMessage()).build();
    }
}
