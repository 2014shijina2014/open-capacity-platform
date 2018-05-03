
package com.open.capacity;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年1月13日 上午10:15:43 
* 类说明 
*/

@RestController
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ConfigGateWayApp {
	
	@Resource
	private Environment environment  ;
	
	@Resource
	private ZuulProperties zuulProperties ;
	
	
	@GetMapping("/gp")
	public String getProps(){
		return environment.getProperty("zuul.debug.request");
	}
	
	@GetMapping("/test")
	public Map<String, ZuulRoute> getPro(){
		return zuulProperties.getRoutes();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigGateWayApp.class, args);
		
	}
}
