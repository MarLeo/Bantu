package com.tchokonthe.details;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static org.springframework.boot.SpringApplication.run;

@EnableEurekaClient
@SpringBootApplication
public class DetailsServiceApplication {

	public static void main(String[] args) {
		run(DetailsServiceApplication.class, args);
	}
}
