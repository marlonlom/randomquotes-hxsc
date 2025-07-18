/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.marlonlom.demos.hexagonalarch.randomquotes.application.port.inbound.GetRandomQuoteUseCase;
import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponse;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponseItem;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.mapper.RandomQuoteResponseRestMapper;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RandomQuoteRestAdapter.class)
class RandomQuoteRestAdapterTest {

    @Autowired private MockMvc mockMvc;

    @MockitoBean private GetRandomQuoteUseCase getRandomQuoteUseCase;

    @MockitoBean private RandomQuoteResponseRestMapper randomQuoteRestMapper;

    @Test
    void testGetRandomQuote() throws Exception {
        RandomQuote mockQuote =
                new RandomQuote(
                        "This is a random quote.",
                        "John Doe",
                        Arrays.asList("one", "two"),
                        1L,
                        "13510");
        RandomQuoteResponse mockResponse = new RandomQuoteResponse();
        mockResponse.setQuote(
                RandomQuoteResponseItem.builder()
                        .author(mockQuote.getAuthor())
                        .authorId(mockQuote.getAuthor_id())
                        .id(mockQuote.getId())
                        .text(mockQuote.getText())
                        .tags(String.join(",", mockQuote.getTags()).trim())
                        .build());

        when(getRandomQuoteUseCase.getRandomQuote()).thenReturn(mockQuote);
        when(randomQuoteRestMapper.toRandomQuoteResponse(mockQuote)).thenReturn(mockResponse);

        mockMvc.perform(get("/v1/quotes/random"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quote.author").value("John Doe"))
                .andExpect(jsonPath("$.quote.text").value("This is a random quote."));
    }
}
