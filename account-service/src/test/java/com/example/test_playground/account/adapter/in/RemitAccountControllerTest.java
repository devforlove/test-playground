package com.example.test_playground.account.adapter.in;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import support.IntegrationTestSupport;

class RemitAccountControllerTest extends IntegrationTestSupport {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Test
	void remitMoney() {
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when().post("/test/assured")
				.then().log().all()
				.extract();

//		final JsonPath result = response.jsonPath();
//		assertAll(
//				() -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
//				() -> assertThat(result.getString("winners")).isEqualTo(""),
//				() -> assertThat(result.getList("racingCars.position", Integer.class))
//						.containsExactly(9, 7, 3)
//		);
	}
}