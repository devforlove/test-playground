package com.example.test_playground;

import org.springframework.boot.SpringApplication;

public class TestTestPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.from(BankServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
