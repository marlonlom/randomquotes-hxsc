/*
 * Copyright 2025 marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for defining application-wide Spring beans. <br>
 * <br>
 * This class registers infrastructure-level beans that can be injected throughout the application
 * using Spring's dependency injection mechanism.
 *
 * @author marlonlom
 * @version 1.0.0
 */
@Configuration
public class BeanConfiguration {

    /**
     * Creates and configures a {@link RestTemplate} bean.<br>
     * <br>
     * {@code RestTemplate} is used to perform synchronous HTTP requests to external APIs or
     * services. It can be injected wherever HTTP communication is needed.
     *
     * @return a new instance of {@link RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
