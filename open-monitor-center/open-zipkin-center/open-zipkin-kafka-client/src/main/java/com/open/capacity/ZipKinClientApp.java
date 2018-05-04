package com.open.capacity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ZipKinClientApp {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/world")
	public String world() {
		return "world";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	private static final Logger logger = LoggerFactory.getLogger(ZipKinClientApp.class);

	public static void main(String[] args) {
		SpringApplication.run(ZipKinClientApp.class, args);
	}
}