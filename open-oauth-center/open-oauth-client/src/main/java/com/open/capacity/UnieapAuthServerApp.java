/**
 * 
 */
package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21
* 类说明 
*/
 
@SpringBootApplication
@Configuration
@EnableAuthorizationServer
public class UnieapAuthServerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(UnieapAuthServerApp.class, args);
	}

}
