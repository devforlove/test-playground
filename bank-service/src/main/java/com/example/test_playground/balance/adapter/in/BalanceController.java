package com.example.test_playground.balance.adapter.in;

import com.example.test_playground.BankResponseEntity;
import com.example.test_playground.response.CheckBalanceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

	@GetMapping("/bank/{memberId}/balance")
	public BankResponseEntity<CheckBalanceResponse> checkBalance(@PathVariable Long memberId) {
		return new BankResponseEntity<>(new CheckBalanceResponse(1000L));
	}
}
