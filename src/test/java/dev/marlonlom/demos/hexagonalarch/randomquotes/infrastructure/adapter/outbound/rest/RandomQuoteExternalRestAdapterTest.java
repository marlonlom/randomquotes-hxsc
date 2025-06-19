package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.outbound.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.outbound.rest.RandomQuoteExternalRestAdapter;

@SpringBootTest
class RandomQuoteExternalRestAdapterTest {

	@MockitoBean
	private RestTemplate restTemplate;

	@Autowired
	private RandomQuoteExternalRestAdapter adapter;

	@Test
	void testGetRandomQuote_Success() throws Exception {
		RandomQuote mockQuote = new RandomQuote("This is a random quote.", "John Doe", Arrays.asList("one", "two"), 1L,
				"13510");
		ResponseEntity<RandomQuote> responseEntity = ResponseEntity.ok(mockQuote);

		when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(RandomQuote.class)))
				.thenReturn(responseEntity);

		Optional<RandomQuote> result = adapter.getRandomQuote();

		assertNotNull(result);
		assertTrue(result.isPresent());
		assertEquals(1L, result.get().getId());
		assertEquals("John Doe", result.get().getAuthor());
		assertEquals("This is a random quote.", result.get().getText());
	}

	@Test
	void testGetRandomQuote_Error() {
		when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(RandomQuote.class)))
				.thenThrow(new RuntimeException("API error"));

		Optional<RandomQuote> result = adapter.getRandomQuote();

		assertNotNull(result);
		assertEquals(Optional.empty(), result);
	}
}
