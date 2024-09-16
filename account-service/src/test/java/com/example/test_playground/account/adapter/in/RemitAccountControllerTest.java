package com.example.test_playground.account.adapter.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.test_playground.account.adapter.out.persistence.AccountEntity;
import com.example.test_playground.account.adapter.out.persistence.AccountRepository;
import com.example.test_playground.client.BankBalanceClient;
import com.example.test_playground.integration.AccountIntegrationSupport;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class RemitAccountControllerTest extends AccountIntegrationSupport {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	void remitMoney() {
		accountRepository.save(new AccountEntity(1L, 2000L));
		accountRepository.save(new AccountEntity(2L, 3000L));

		Map<String, Object> params = new HashMap<>();
		params.put("amount", 1000);

		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.body(params)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when().post("/remittance/1/to/2")
				.then().log().all()
				.extract();

		final JsonPath result = response.jsonPath();
		assertAll(
				() -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
				() -> assertThat(result.getLong("amount")).isEqualTo(1000)
		);
	}
}