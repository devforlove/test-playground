package com.example.test_playground.account.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface AccountRepository extends Repository<AccountEntity, Long> {

	void save(AccountEntity account);
	Optional<AccountEntity> findByAccountId(Long accountId);
}
