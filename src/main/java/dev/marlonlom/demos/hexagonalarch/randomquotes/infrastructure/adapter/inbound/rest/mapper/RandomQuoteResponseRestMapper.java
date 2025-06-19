package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.mapper;

import org.springframework.stereotype.Component;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model.RandomQuote;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponse;
import dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response.RandomQuoteResponseItem;

/**
 * Maps domain models to REST response objects for random quotes.<br>
 * This component is responsible for converting {@link RandomQuote} domain
 * entities into {@link RandomQuoteResponse} or related DTOs for API responses.
 * 
 * @author marlon.lopez
 * @version 1.0.0
 */
@Component
public class RandomQuoteResponseRestMapper {

	/**
	 * Converts a {@link RandomQuote} domain object into a
	 * {@link RandomQuoteResponse} suitable for REST API responses.
	 *
	 * @param randomQuoteDomainObject the domain object representing a random quote
	 * @return a {@link RandomQuoteResponse} containing the mapped quote information
	 */
	public RandomQuoteResponse toRandomQuoteResponse(RandomQuote randomQuoteDomainObject) {
		RandomQuoteResponse response = new RandomQuoteResponse();
		response.setQuote(RandomQuoteResponseItem.builder().id(randomQuoteDomainObject.getId())
				.authorId(randomQuoteDomainObject.getAuthor_id()).author(randomQuoteDomainObject.getAuthor())
				.text(randomQuoteDomainObject.getText())
				.tags(String.join(",", randomQuoteDomainObject.getTags()).trim()).build());
		return response;
	}

}
