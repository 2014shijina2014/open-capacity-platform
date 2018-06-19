package com.open.capacity.server.oauth2.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	 
	
	 

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = { "/users" }, produces = "application/json") // 获取用户信息。/auth/user
	public Map<String, Object> user( ) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		logger.debug("认证详细信息:" + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities()));
		return userInfo;
	}
	
	@RequestMapping(value = { "/user" }, produces = "application/json") // 获取用户信息。/auth/user
    public Principal user(Principal user) {
        return user;
    }
	
	
}
