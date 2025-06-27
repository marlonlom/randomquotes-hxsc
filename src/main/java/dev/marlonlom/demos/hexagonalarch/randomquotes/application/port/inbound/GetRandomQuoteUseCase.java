package dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.inbound;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;

/**
 * Use case interface for retrieving a random quote from the system. <br>
 * <br>
 * This interface defines the contract for application-level services that provide random quotes. It
 * is part of the application's business logic layer, abstracting away the source of the quote
 * (e.g., database, external API). <br>
 * <br>
 * Implementations may retrieve quotes from different sources via output ports.
 *
 * @author marlon.lopez
 * @version 1.0.0
 * @see RandomQuote
 */
public interface GetRandomQuoteUseCase {

    /**
     * Retrieves a single random quote.
     *
     * @return a {@link RandomQuote} domain object
     */
    RandomQuote getRandomQuote();
}
