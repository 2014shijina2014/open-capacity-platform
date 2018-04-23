package com.open.capacity.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */

@RestController
@EnableOAuth2Client  
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Resource
	private RestTemplate restTemplate ;
 
	
	@Autowired(required=false)  
    private OAuth2ClientContext oauth2Context;  
	
 
	
	 

	@GetMapping("/test111")
	public String hello() {
		
		System.out.println("11111============="+oauth2Context.getAccessToken());
		
		 
		ResponseEntity<String> restExchange =
                restTemplate.exchange(
//                    "http://localhost:5555/demo/service-four/{id}",
                		"http://127.0.0.1:8100/test111?access_token=" + oauth2Context.getAccessToken().getValue() ,
                        HttpMethod.GET,
                        null, String.class );
		
		return restExchange.getBody();
	}

	 
}
