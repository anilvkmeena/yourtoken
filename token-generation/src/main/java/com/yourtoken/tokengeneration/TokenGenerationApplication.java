package com.yourtoken.tokengeneration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TokenGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenGenerationApplication.class, args);
	}

}
