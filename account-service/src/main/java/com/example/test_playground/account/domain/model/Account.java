package com.example.test_playground.account.domain.model;

import lombok.Builder;

public class Account {
	private final long memberId;
	private final long balance;

	@Builder
	public Account(long memberId, long balance) {
		this.memberId = memberId;
		this.balance = balance;
	}

	public static Account generate(long memberId, long balance) {
		return Account.builder()
				.memberId(memberId)
				.balance(balance)
				.build();
	}
}
