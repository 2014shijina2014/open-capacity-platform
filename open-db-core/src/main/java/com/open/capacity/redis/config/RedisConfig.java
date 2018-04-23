package com.open.capacity.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.open.capacity.redis.config.util.RedisObjectSerializer;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年04月23日 下午20:01:06 类说明
 */
@Configuration
public class RedisConfig {

	@Primary
	@Bean("redisTemplate")
	// 没有此属性就不会装配bean 如果是单个redis 将此注解注释掉
	@ConditionalOnProperty(name = "spring.redis.cluster.nodes", matchIfMissing = false)
	public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);

		RedisSerializer stringSerializer = new StringRedisSerializer();
		// RedisSerializer redisObjectSerializer = new RedisObjectSerializer();
		RedisSerializer redisObjectSerializer = new RedisObjectSerializer();
		redisTemplate.setKeySerializer(stringSerializer); // key的序列化类型
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(redisObjectSerializer); // value的序列化类型
		redisTemplate.afterPropertiesSet();

		redisTemplate.opsForValue().set("hello", "wolrd");
		return redisTemplate;
	}

	@Primary
	@Bean("redisTemplate")
	@ConditionalOnProperty(name = "spring.redis.host", matchIfMissing = true)
	public RedisTemplate<String, Object> getSingleRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
		redisTemplate.setValueSerializer(new RedisObjectSerializer()); // value的序列化类型
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

}
