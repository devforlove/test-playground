package com.example.test_playground.integration;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.web.server.LocalServerPort;
import support.IntegrationTestSupport;

public abstract class AccountIntegrationSupport extends IntegrationTestSupport {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}
}
