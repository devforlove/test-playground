package com.example.test_playground.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import java.time.Duration;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerCustomConfig {

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> autoHalf() {
		CircuitBreakerConfig cbConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(50)
				.slidingWindowSize(5)
				.enableAutomaticTransitionFromOpenToHalfOpen()
				.ignoreExceptions(Exception.class, RuntimeException.class)
				.waitDurationInOpenState(Duration.ofSeconds(5))
				.build();

		return factory -> {
			factory.configure(builder -> {
				builder.circuitBreakerConfig(cbConfig);
			});
		};
	}
}
