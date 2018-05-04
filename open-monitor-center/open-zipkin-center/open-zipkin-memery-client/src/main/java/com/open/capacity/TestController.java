package com.open.capacity;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/** 
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51 类说明
* 类说明 
*/
@RestController
public class TestController {
	
	@Resource
	private RestTemplate restTemplate ;

	@GetMapping(value="/hello")
	public String hello(){
		return "hello" ;
	}
	
	@GetMapping(value="/world")
	public String world(){
		
		
		return restTemplate.getForObject("http://unieap-eureka-client/hello", String.class) ;
	}
	
}
