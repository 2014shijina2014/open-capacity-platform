package com.open.capacity;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class UnieapBusApp {
	
	@GetMapping("/config/refreshAll")
	public String refresh(){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://127.0.0.1:8201/bus/refresh");
		HttpResponse response;
		try {
			response = client.execute(post);
			return EntityUtils.toString(response.getEntity()) ;
		} catch (Exception e) {
			throw new RuntimeException("运行失败");
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(UnieapBusApp.class, args);
		
	}

}
