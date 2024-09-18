package com.example.test_playground.client;

import feign.Request;
import feign.Retryer;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankClientFeignConfig {
//	@Bean
//	public Request.Options requestOptions() {
//		long connectionTimeout = 10;
//		long readTimeout = 5; // read - timeout 5초로 설정
//		return new Request.Options(connectionTimeout, TimeUnit.SECONDS, readTimeout, TimeUnit.SECONDS, false);
//	}
}
