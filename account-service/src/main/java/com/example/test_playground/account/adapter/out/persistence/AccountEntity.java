package com.example.test_playground.account.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private Long memberId;
	private Long balance;

	public AccountEntity(Long memberId, Long balance) {
		this.memberId = memberId;
		this.balance = balance;
	}
}
