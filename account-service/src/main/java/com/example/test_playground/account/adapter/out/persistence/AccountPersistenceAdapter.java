package com.example.test_playground.account.adapter.out.persistence;

import com.example.test_playground.account.adapter.out.persistence.mapper.AccountMapper;
import com.example.test_playground.account.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter {

	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;

	public Account findMemberAccount(long accountId) {
		return accountMapper.toDomain(accountRepository.findByAccountId(accountId));
	}

	public void updateAccount(Account account) {

	}
}
