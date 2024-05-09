package com.web.sample.poc.DatabaseManagerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @EnableEurekaClient deprecated and without adding this annotation
 * if we add dependency of eureka client it will automatically makes this service as client
 */
@SpringBootApplication
public class DatabaseManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseManagerServiceApplication.class, args);
	}

}
