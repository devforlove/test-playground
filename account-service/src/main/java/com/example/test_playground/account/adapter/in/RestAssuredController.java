package com.example.test_playground.account.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAssuredController {

	@PostMapping(value = "/test/assured")
	public ResponseEntity<String> ddd() {

		return ResponseEntity.ok("sss");
	}
}
