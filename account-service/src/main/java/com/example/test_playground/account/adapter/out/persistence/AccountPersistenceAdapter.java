package com.example.test_playground.account.adapter.out.persistence;

import com.example.test_playground.account.adapter.out.persistence.mapper.AccountMapper;
import com.example.test_playground.account.domain.model.Account;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter {

	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;

	public Optional<Account> findMemberAccount(long accountId) {
		if (accountRepository.findByAccountId(accountId).isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(accountMapper.toDomain(accountRepository.findByAccountId(accountId).get()));
	}

	public void updateAccount(Account account) {

	}
}
