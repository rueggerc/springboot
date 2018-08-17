package com.rueggerllc.books.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceGatewayApplication.class, args);
	}
}
