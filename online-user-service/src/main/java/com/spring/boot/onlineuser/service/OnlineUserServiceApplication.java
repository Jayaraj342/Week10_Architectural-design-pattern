package com.spring.boot.onlineuser.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineUserServiceApplication.class, args);
	}
}
