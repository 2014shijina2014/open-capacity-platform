/**
 * 
 */
package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.client.RestTemplate;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月12日 上午22:57:51
* 类说明 
*/
 
@SpringBootApplication
@Configuration
public class UnieapAuthServerApp {
	
	 @Bean
		@LoadBalanced
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}

	
	public static void main(String[] args) {
		SpringApplication.run(UnieapAuthServerApp.class, args);
	}

}
