package com.stackroute.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHealthCareServiceRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHealthCareServiceRepositoryApplication.class, args);
	}

}
