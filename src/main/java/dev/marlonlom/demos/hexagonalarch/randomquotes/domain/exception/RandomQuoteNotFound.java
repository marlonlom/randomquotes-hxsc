/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.domain.exception;

import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.failure.RandomQuoteNotFoundAdvice;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Exception thrown when a random quote cannot be found. <br>
 * <br>
 * This runtime exception is typically used in the application or domain layer to signal that no
 * quote was retrieved from the data source (e.g., external API, database). <br>
 * <br>
 * Handled by global exception handlers (e.g., {@code @RestControllerAdvice}) to return an
 * appropriate HTTP response to the client.
 *
 * @author marlonlom
 * @version 1.0.0
 * @see RuntimeException
 * @see RandomQuoteNotFoundAdvice
 */
@Schema(implementation = RandomQuoteNotFound.class)
public class RandomQuoteNotFound extends RuntimeException {

    /** serialVersionUID. */
    private static final long serialVersionUID = -1602990077934180647L;

    /** Constructs a new {@link RandomQuoteNotFound} exception with a default message. */
    public RandomQuoteNotFound() {
        super("Random quote not found.");
    }
}
