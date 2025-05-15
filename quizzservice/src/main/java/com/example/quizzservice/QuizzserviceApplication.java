package com.example.quizzservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizzserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizzserviceApplication.class, args);
	}

}
