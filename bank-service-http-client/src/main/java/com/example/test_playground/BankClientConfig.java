package com.example.test_playground;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.example.test_playground.client")
public class BankClientConfig {

}
