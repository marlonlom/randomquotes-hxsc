/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.outbound.RandomQuoteOutboundPort;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.exception.RandomQuoteNotFound;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class RandomQuoteServiceTest {

    @MockitoBean private RandomQuoteOutboundPort randomQuoteOutputPort;

    @Autowired private RandomQuoteService randomQuoteService;

    @Test
    void testGetRandomQuote_Success() {
        RandomQuote expectedQuote =
                new RandomQuote("Lorem ipsumn", "me", Arrays.asList("one", "two"), 1L, "13510");
        when(randomQuoteOutputPort.getRandomQuote()).thenReturn(Optional.of(expectedQuote));
        RandomQuote actualQuote = randomQuoteService.getRandomQuote();
        assertEquals(expectedQuote, actualQuote);
    }

    @Test
    void testGetRandomQuote_NotFound() {
        when(randomQuoteOutputPort.getRandomQuote()).thenReturn(Optional.empty());
        assertThrows(RandomQuoteNotFound.class, () -> randomQuoteService.getRandomQuote());
    }
}
