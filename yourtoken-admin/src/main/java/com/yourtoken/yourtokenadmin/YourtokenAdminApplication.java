package com.yourtoken.yourtokenadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class YourtokenAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourtokenAdminApplication.class, args);
	}

}
