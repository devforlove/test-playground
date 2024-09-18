package com.example.test_playground.account.adapter.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.test_playground.account.adapter.out.persistence.AccountEntity;
import com.example.test_playground.account.adapter.out.persistence.AccountRepository;
import com.example.test_playground.client.BankBalanceClient;
import com.example.test_playground.integration.AccountIntegrationSupport;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class RemitTimeoutTest extends AccountIntegrationSupport {

	@Autowired
	BankBalanceClient bankBalanceClient;

	@Test
	void testReadTimeout() {
		Throwable throwable = catchThrowable(() -> bankBalanceClient.checkBalance(2));

		assertThat(throwable)
				.as("SocketTimeoutException 발생")
				.hasCauseInstanceOf(SocketTimeoutException.class)
				.hasMessageContaining("Read timed out");
	}
}