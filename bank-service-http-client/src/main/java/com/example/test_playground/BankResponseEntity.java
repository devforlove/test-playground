package com.example.test_playground;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BankResponseEntity <T> {

	private T data;

	public BankResponseEntity(T data) {
		this.data = data;
	}
}
