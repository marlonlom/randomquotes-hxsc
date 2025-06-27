/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.domain.service;

import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.inbound.GetRandomQuoteUseCase;
import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.outbound.RandomQuoteOutboundPort;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.exception.RandomQuoteNotFound;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class that provides functionality to retrieve random quotes. <br>
 * <br>
 * This class implements the {@link GetRandomQuoteUseCase} interface, which defines the contract for
 * fetching random quotes.
 *
 * @author marlonlom
 * @version 1.0.0
 */
@Service
public class RandomQuoteService implements GetRandomQuoteUseCase {

    /** Output port for accessing the random quote source. */
    @Autowired private RandomQuoteOutboundPort randomQuoteOutputPort;

    @Override
    public RandomQuote getRandomQuote() {
        return this.randomQuoteOutputPort
                .getRandomQuote()
                .orElseThrow(() -> new RandomQuoteNotFound());
    }
}
