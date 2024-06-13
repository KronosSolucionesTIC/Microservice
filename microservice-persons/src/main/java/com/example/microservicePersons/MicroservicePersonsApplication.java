package com.example.microservicePersons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroservicePersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePersonsApplication.class, args);
	}

}
