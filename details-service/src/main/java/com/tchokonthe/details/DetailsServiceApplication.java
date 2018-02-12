package com.tchokonthe.details;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableEurekaClient
public class DetailsServiceApplication {

	public static void main(String[] args) {
		run(DetailsServiceApplication.class, args);
	}
}
