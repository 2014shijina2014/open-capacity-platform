package com.open.capacity.config;

import com.open.capacity.server.oauth2.token.store.RedisTemplateTokenStore;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: [gitgeek]
 * @Date: [2018-07-12 11:32]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Component
@Configuration
public class FeignConfig  implements RequestInterceptor  {

    private static final String TOKEN_KEY = "access_token";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("access_token",getToken(getHttpServletRequest()));
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

//    private Map<String, String> getHeaders(HttpServletRequest request) {
//        Map<String, String> map = new LinkedHashMap<>();
//        Enumeration<String> enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()) {
//            String key = enumeration.nextElement();
//            String value = request.getHeader(key);
//            map.put(key, value);
//        }
//        return map;
//    }

    /**
     * 根据参数或者header获取token
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(TOKEN_KEY);
        }

        return token;
    }


}
