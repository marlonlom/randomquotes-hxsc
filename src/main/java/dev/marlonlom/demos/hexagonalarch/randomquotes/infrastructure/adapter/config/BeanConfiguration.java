package dev.marlonlom.demos.hexagonalarch.randomquotes.infrastructure.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for defining application-wide Spring beans.
 * 
 * <p>
 * This class registers infrastructure-level beans that can be injected
 * throughout the application using Spring's dependency injection mechanism.
 * </p>
 * 
 * @author marlon.lopez
 * @version 1.0.0
 */
@Configuration
public class BeanConfiguration {

	/**
	 * Creates and configures a {@link RestTemplate} bean.
	 * 
	 * <p>
	 * {@code RestTemplate} is used to perform synchronous HTTP requests to external
	 * APIs or services. It can be injected wherever HTTP communication is needed.
	 * </p>
	 *
	 * @return a new instance of {@link RestTemplate}
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
