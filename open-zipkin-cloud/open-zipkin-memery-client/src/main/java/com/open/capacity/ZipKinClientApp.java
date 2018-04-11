package com.open.capacity;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2017年12月4日 下午5:30:29 
* 类说明 
*/
@EnableEurekaClient
@SpringBootApplication
public class ZipKinClientApp {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZipKinClientApp.class, args);
	}
} 
