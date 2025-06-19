package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.response;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a single item in the response from a random quote api or service.
 * 
 * @author marlon.lopez
 * @version 1.0.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Random quote success response detail")
public class RandomQuoteResponseItem implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1469182648157012811L;

	/** The random quote response id. */
	@Schema(description = "Random quote response id")
	private Long id;

	/** The random quote response author id. */
	@Schema(description = "Random quote author id")
	private String authorId;

	/** The random quote response author. */
	@Schema(description = "Random quote author name")
	private String author;

	/** The random quote response text. */
	@Schema(description = "Random quote text")
	private String text;

	/** The random quote response tags. */
	@Schema(description = "Random quote tags, separated by comma")
	private String tags;
}
