
package com.open.capacity.client.oauth2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.client.oauth2.token.store.RedisTemplateTokenStore;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Component
@Configuration
@EnableResourceServer
public class OAuth2ClientConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired(required=false)
	private RedisTemplateTokenStore redisTemplateTokenStore ;

	//对应oauth_client_details的 resource_ids字段 如果表中有数据 client_id只能访问响应resource_ids的资源服务器
	private static final String DEMO_RESOURCE_ID = "test";

	@Resource
	private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类

	@Autowired(required = false)
	private TokenStore redisTokenStore;

	@Autowired(required = false)
	private JwtTokenStore jwtTokenStore;
	@Autowired(required = false)
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		if (jwtTokenStore != null) {
			resources.tokenStore(jwtTokenStore);
		} else if (redisTokenStore != null) {
			resources.tokenStore(redisTokenStore);
		}
		resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
		
		resources.authenticationEntryPoint(authenticationEntryPoint) ;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
				.authorizeRequests().anyRequest().authenticated().and().httpBasic();

	}

}
