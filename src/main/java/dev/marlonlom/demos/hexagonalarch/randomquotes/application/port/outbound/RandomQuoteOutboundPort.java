package dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.outbound;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import java.util.Optional;

/**
 * Outbound port interface for retrieving a random quote from a data source.
 *
 * @author marlon.lopez
 * @version 1.0.0
 */
public interface RandomQuoteOutboundPort {

    /**
     * Retrieves a random quote from an external REST API or service. <br>
     * <br>
     * This method makes a call to an external source and maps the response to the domain model
     * {@link RandomQuote}. If no quote is found or the request fails, an empty {@link Optional} is
     * returned.
     *
     * @return an {@link Optional} containing a {@link RandomQuote} if successfully retrieved, or
     *     empty otherwise
     */
    Optional<RandomQuote> getRandomQuote();
}
