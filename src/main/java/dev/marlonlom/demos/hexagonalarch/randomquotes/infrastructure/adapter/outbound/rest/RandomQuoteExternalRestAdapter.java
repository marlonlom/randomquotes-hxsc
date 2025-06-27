package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.outbound.rest;

import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.outbound.RandomQuoteOutboundPort;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * External REST adapter that implements the {@link RandomQuoteOutboundPort} to fetch random quotes
 * from an external API or REST service. <br>
 * <br>
 * This class serves as the infrastructure implementation of the output port, allowing the
 * application to remain decoupled from specific REST client logic.
 *
 * @author marlon.lopez
 * @version 1.0.0
 * @see RandomQuoteOutboundPort
 */
@Component
@Log4j2
public class RandomQuoteExternalRestAdapter implements RandomQuoteOutboundPort {

    /** Base URL of the external Random Quotes API. */
    @Value("${randomquotes.api.url}")
    private String apiUrl;

    /** HTTP client used to perform REST calls to external services. */
    @Autowired private RestTemplate restTemplate;

    @Override
    public Optional<RandomQuote> getRandomQuote() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            ResponseEntity<RandomQuote> response =
                    restTemplate.exchange(
                            apiUrl,
                            HttpMethod.GET,
                            new org.springframework.http.HttpEntity<>(headers),
                            RandomQuote.class);
            RandomQuote quote = response.getBody();
            log.info("Found random quote: {}", quote);
            return Optional.of(quote);
        } catch (Exception e) {
            log.error("Error fetching random quote: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
