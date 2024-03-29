package com.poc.contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotmartIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotmartIntegrationApplication.class, args);
	}

}
