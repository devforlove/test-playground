package com.example.test_playground.account.adapter.out.web;

import com.example.test_playground.BankResponseEntity;
import com.example.test_playground.client.BankBalanceClient;
import com.example.test_playground.response.CheckBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankClientAdapter {

	private final BankBalanceClient bankBalanceClient;

	public long checkBalance(long memberId) {
		BankResponseEntity<CheckBalanceResponse> response = bankBalanceClient.checkBalance(memberId);
		return response.getData().balance();
	}
}
