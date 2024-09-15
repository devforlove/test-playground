package com.example.test_playground.account.adapter.out.web;

import com.example.test_playground.client.BankBalanceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankClientAdapter {

	private final BankBalanceClient bankBalanceClient;


}
