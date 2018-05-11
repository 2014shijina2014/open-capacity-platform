package com.xxl.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.open.capacity","com.xxl.job"})
@SpringBootApplication
public class XXLJobApp {

	public static void main(String[] args) {
		SpringApplication.run(XXLJobApp.class, args);
	}
}
