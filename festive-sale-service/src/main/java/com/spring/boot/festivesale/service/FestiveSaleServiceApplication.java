package com.spring.boot.festivesale.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FestiveSaleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestiveSaleServiceApplication.class, args);
	}
}
