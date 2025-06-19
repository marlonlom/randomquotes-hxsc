package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a success response for random quote requests.
 *
 * @see RandomQuoteResponseItem
 * 
 * @author marlon.lopez
 * @version 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Random quote success response")
public class RandomQuoteResponse implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 6244846586612667611L;

	/** The quote data to be returned in the response. */
	@Schema(description = "Random quote success response detail")
	private RandomQuoteResponseItem quote;

}
