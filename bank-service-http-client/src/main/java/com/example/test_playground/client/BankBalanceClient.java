package com.example.test_playground.client;

import com.example.test_playground.BankResponseEntity;
import com.example.test_playground.response.CheckBalanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "bankClient",
		url = "${feign.url.bank-url}",
		configuration = BankClientFeignConfig.class
)
public interface BankBalanceClient {

	@GetMapping("/bank/{memberId}/balance")
	BankResponseEntity<CheckBalanceResponse> checkBalance(@PathVariable long memberId);
}
