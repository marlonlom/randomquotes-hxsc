/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.failure;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a failure response for random quote requests.
 *
 * @author marlonlom
 * @version 1.0.0
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Random quote failure")
public class RandomQuoteFailure implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3013170982309865436L;

    /** Error message. */
    @Schema(description = "Error message")
    private String error;
}
