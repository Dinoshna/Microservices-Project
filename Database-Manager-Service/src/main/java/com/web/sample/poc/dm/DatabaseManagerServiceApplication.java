package com.web.sample.poc.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @EnableEurekaClient deprecated and without adding this annotation
 * if we add dependency of eureka client it will automatically makes this service as client
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DatabaseManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseManagerServiceApplication.class, args);
	}

}
