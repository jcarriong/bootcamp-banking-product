package com.bootcamp.bankingproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankingProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingProductApplication.class, args);
	}

}
