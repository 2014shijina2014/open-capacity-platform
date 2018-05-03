
package com.open.capacity;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年1月13日 上午10:15:43 
* 类说明 
*/
@RestController
@EnableDiscoveryClient
@SpringBootApplication  
public class EurekaConfigClientApp {
	
	@Resource
	private Environment environment  ;
	
	@GetMapping("/gp")
	public String getProps(){
		return environment.getProperty("zuul.debug.request");
	}
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(EurekaConfigClientApp.class, args);
		
	}
}
