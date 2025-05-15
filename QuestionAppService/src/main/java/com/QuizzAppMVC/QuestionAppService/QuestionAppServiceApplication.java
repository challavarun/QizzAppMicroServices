package com.QuizzAppMVC.QuestionAppService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QuestionAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAppServiceApplication.class, args);
	}

}
