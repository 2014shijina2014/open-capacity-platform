package com.open.capacity;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月12日 上午22:57:51
*/

@RestController
@SpringBootApplication
public class SsoClientApp {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@RequestMapping(value = { "/user" }, produces = "application/json") // 获取用户信息。/auth/user
    public Principal user(Principal user) {
        return user;
    }
	@GetMapping("/users")
	public Authentication user(Authentication user) {
		return user;
	}
	public static void main(String[] args) {
		SpringApplication.run(SsoClientApp.class, args);
	}
}
