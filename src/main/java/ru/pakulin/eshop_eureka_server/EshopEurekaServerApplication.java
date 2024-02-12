package ru.pakulin.eshop_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EshopEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopEurekaServerApplication.class, args);
	}

}
