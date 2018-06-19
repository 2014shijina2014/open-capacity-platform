package com.open.capacity.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.client.oauth2.token.store.RedisTemplateTokenStore;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年4月5日 下午19:52:21
 */
@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private RedisTemplate< String, Object> redisTemplate ;
	
	 

	@GetMapping("/hello")
	@PreAuthorize("hasAuthority('sys:user:add11')")
	public String hello() {
		redisTemplate.opsForValue().set("hello", "owen");
		return "hello";
	}

	@RequestMapping(value = { "/users" }, produces = "application/json") // 获取用户信息。/auth/user
	public Map<String, Object> user(OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		logger.debug("认证详细信息:" + user.getUserAuthentication().getPrincipal().toString());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return userInfo;
	}
	
	@RequestMapping(value = { "/user" }, produces = "application/json") // 获取用户信息。/auth/user
    public Principal user(Principal user) {
        return user;
    }
	
	
	@GetMapping("/del/{accessToken}/{refreshToken}")
	public String hello2(@PathVariable String accessToken,@PathVariable String refreshToken) {
		RedisTemplateTokenStore redisTemplateStore = new RedisTemplateTokenStore();
		redisTemplateStore.setRedisTemplate(redisTemplate);
		redisTemplateStore.removeAccessToken(accessToken);
		redisTemplateStore.removeRefreshToken(refreshToken);
		return "delR";
	}
}
