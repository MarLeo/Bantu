package com.tchokonthe.server.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

	public static void main(String[] args) {
		run(EurekaServer.class, args);
	}
}
