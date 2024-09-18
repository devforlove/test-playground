package com.example.test_playground.account.application;

import com.example.test_playground.account.adapter.out.persistence.AccountPersistenceAdapter;
import com.example.test_playground.account.adapter.out.web.BankClientAdapter;
import com.example.test_playground.account.domain.model.Account;
import com.example.test_playground.account.domain.service.RemittanceExecutor;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RemitAccountService {

	private final AccountPersistenceAdapter remittancePersistenceAdapter;
	private final BankClientAdapter bankClientAdapter;

	@Transactional
	public long remit(long senderId, long receiverId, long amount) {
		long balance = bankClientAdapter.checkBalance(senderId);
		final Optional<Account> senderAccount = remittancePersistenceAdapter.findMemberAccount(senderId);
		final Optional<Account> receiverAccount = remittancePersistenceAdapter.findMemberAccount(receiverId);

//		senderAccount.orElseThrow(
//				() -> new IllegalArgumentException("sender account not exist")
//		);
//
//		receiverAccount.orElseThrow(
//				() -> new IllegalArgumentException("receiver account not exist")
//		);

//		final RemittanceExecutor remittanceExecutor = new RemittanceExecutor();
//		remittanceExecutor.execute(senderAccount.get(), receiverAccount.get(), amount);

		return balance;
	}
}
