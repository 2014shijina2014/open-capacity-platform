package com.open.capacity.server.oauth2.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;

import java.util.concurrent.TimeUnit;

/**
 * 基于redis重写Oauth2授权码模式逻辑
 *
 * @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 * {@link RandomValueAuthorizationCodeServices 一个基础的授权码实现，实现AuthorizationCodeServices接口}
 */
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    /**
     * remove OAuth2Authentication 认证信息
     *
     * @param code
     * @return
     */
    @Override
    protected OAuth2Authentication remove(final String code) {
        String codeKey = redisKey(code);
        OAuth2Authentication token = (OAuth2Authentication) redisTemplate.opsForValue().get(codeKey);
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
