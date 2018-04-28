package com.open.capacity.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月28日 下午21:52:43
* 类说明 
*/
@RestController
public class HelloController {

	@Resource
	private RestTemplate restTemplate ;
	
	@GetMapping("/hello")
	public String hello(  HttpServletRequest request){
		return  "hello:	" ;
	}
	
	@GetMapping("/route")
	public String hello1(){
		String resp = this.restTemplate.getForObject("http://unieap-eureka-client/hello", String.class);
		return resp;
	}
}
