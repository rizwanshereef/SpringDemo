package com.stackroute.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IPolicyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IPolicyMsApplication.class, args);
	}

}
