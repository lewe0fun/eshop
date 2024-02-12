package ru.paklulin.eshop_eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EshopEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopEurekaServiceApplication.class, args);
	}

}
