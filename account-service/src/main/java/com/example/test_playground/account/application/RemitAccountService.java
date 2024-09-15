package com.example.test_playground.account.application;

import com.example.test_playground.account.adapter.out.persistence.AccountPersistenceAdapter;
import com.example.test_playground.account.domain.model.Account;
import com.example.test_playground.account.domain.service.RemittanceExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RemitAccountService {

	private final AccountPersistenceAdapter remittancePersistenceAdapter;

	@Transactional
	public long remit(long senderId, long receiverId, long amount) {
		final Account senderAccount = remittancePersistenceAdapter.findMemberAccount(senderId);
		final Account receiverAccount = remittancePersistenceAdapter.findMemberAccount(receiverId);

		final RemittanceExecutor remittanceExecutor = new RemittanceExecutor();
		remittanceExecutor.execute(senderAccount, receiverAccount, amount);


		return 0L;
	}
}
