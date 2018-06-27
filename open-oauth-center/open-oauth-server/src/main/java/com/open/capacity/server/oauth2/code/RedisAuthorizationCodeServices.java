package com.open.capacity.server.oauth2.code;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

/**
 * @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 * JdbcAuthorizationCodeServices替换
 */
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

	private RedisTemplate<String,Object> redisTemplate ;

	
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 替换JdbcAuthorizationCodeServices的存储策略
	 * 将存储code到redis，并设置过期时间，10分钟<br>
	 */
	@Override
	protected void store(String code, OAuth2Authentication authentication) {
		
		redisTemplate.opsForValue().set(redisKey(code), authentication, 10, TimeUnit.MINUTES);
		
		 
	}

	@Override
	protected OAuth2Authentication remove(final String code) {
		 
		String codeKey =redisKey(code) ;
			
		OAuth2Authentication token = (OAuth2Authentication) redisTemplate.opsForValue().get(codeKey) ;
			
		this.redisTemplate.delete(codeKey); 

		return token;
	}

	/**
	 * redis中 code key的前缀
	 * 
	 * @param code
	 * @return
	 */
	private String redisKey(String code) {
		return "oauth:code:" + code;
	}
}
