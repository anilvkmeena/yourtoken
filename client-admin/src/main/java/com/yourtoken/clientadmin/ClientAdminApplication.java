package com.yourtoken.clientadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAdminApplication.class, args);
	}

}
