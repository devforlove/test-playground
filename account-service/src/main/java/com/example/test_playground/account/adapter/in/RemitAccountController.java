package com.example.test_playground.account.adapter.in;

import com.example.test_playground.account.adapter.in.request.RemittanceRequest;
import com.example.test_playground.account.adapter.in.response.RemittanceResponse;
import com.example.test_playground.account.application.RemitAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RemitAccountController {

	private final RemitAccountService remittanceService;

	@PostMapping("/remittance/{senderId}/to/{receiveId}")
	public ResponseEntity<RemittanceResponse> remitMoney(
			@PathVariable long senderId,
			@PathVariable long receiveId,
			@RequestBody RemittanceRequest request) {
		final long amount = remittanceService.remit(senderId, receiveId, request.amount());
		return ResponseEntity.ok(new RemittanceResponse(amount));
	}
}
