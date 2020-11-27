package com.stackroute.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringBootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDemoApplication.class, args);
	}

}
