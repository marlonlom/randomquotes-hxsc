package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.input.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponse;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponseItem;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.mapper.RandomQuoteResponseRestMapper;

@SpringBootTest
class RandomQuoteResponseRestMapperTest {

	private final RandomQuoteResponseRestMapper mapper = new RandomQuoteResponseRestMapper();

	@Test
	void testToRandomQuoteResponse() {
		RandomQuote randomQuote = new RandomQuote("This is a random quote.", "John Doe",
				Arrays.asList("inspiration", "life"), 1L, "123");
		RandomQuoteResponse response = mapper.toRandomQuoteResponse(randomQuote);
		assertNotNull(response);
		RandomQuoteResponseItem responseItem = response.getQuote();
		assertNotNull(responseItem);
		assertEquals(1L, responseItem.getId());
		assertEquals("123", responseItem.getAuthorId());
		assertEquals("John Doe", responseItem.getAuthor());
		assertEquals("This is a random quote.", responseItem.getText());
		assertEquals("inspiration,life", responseItem.getTags());
	}
}
