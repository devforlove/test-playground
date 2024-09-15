package com.example.test_playground.account.adapter.out.persistence.mapper;

import com.example.test_playground.account.adapter.out.persistence.AccountEntity;
import com.example.test_playground.account.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

	public Account toDomain(AccountEntity accountEntity) {
		return Account.generate(accountEntity.getMemberId(), accountEntity.getBalance());
	}

	public AccountEntity toEntity(Account account) {
		return null;
	}
}
