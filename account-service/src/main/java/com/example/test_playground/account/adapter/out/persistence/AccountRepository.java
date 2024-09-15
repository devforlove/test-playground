package com.example.test_playground.account.adapter.out.persistence;

import org.springframework.data.repository.Repository;

public interface AccountRepository extends Repository<AccountEntity, Long> {

	AccountEntity findByAccountId(Long accountId);
}
