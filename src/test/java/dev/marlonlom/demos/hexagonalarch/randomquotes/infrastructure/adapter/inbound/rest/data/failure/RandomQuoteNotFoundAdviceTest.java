package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.inbound.rest.data.failure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import dev.marlonlom.demos.hexagonalarch.randomquotes.domain.exception.RandomQuoteNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RandomQuoteNotFoundAdviceTest {

    private final RandomQuoteNotFoundAdvice advice = new RandomQuoteNotFoundAdvice();

    @Test
    void testRandomQuoteNotFoundAdvice() {
        final RandomQuoteNotFound exception = new RandomQuoteNotFound();
        RandomQuoteFailure failure = advice.randomQuoteNotFoundHandler(exception);
        assertNotNull(failure);
        assertEquals("Random quote not found.", failure.getError());
    }
}
