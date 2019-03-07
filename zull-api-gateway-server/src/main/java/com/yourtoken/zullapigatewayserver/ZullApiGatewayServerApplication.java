package com.yourtoken.zullapigatewayserver;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZullApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullApiGatewayServerApplication.class, args);
	}
	

}
