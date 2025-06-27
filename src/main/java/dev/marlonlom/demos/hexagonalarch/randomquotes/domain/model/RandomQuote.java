package dev.marlonlom.demos.hexagonalarch.randomquotes.domain.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Domain model representing a random quote. <br>
 * <br>
 * This class encapsulates the essential data for a quote, including its text, author information,
 * tags, and identifiers. It is used within the core domain layer of the application and is designed
 * to be serializable for transport or persistence.
 *
 * @author marlon.lopez
 * @version 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
public class RandomQuote implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 4999399503899363311L;

    /** The content of the quote. */
    private String text;

    /** The name of the author who said or wrote the quote. */
    private String author;

    /** A list of tags or keywords associated with the quote (e.g., "inspiration", "wisdom"). */
    private List<String> tags;

    /** The unique identifier of the quote. */
    private Long id;

    /** The unique identifier of the author. */
    private String author_id;
}
