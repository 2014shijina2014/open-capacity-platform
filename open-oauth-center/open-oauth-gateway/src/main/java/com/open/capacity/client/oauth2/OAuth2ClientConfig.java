
package com.open.capacity.client.oauth2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.client.oauth2.filter.TokenFilter;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Component
@Configuration
@EnableResourceServer
public class OAuth2ClientConfig extends ResourceServerConfigurerAdapter{

 
		@Resource 
		private ObjectMapper objectMapper ; //springmvc启动时自动装配json处理类

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
			resources.stateless(true);
			
			resources.authenticationEntryPoint(authenticationEntryPoint) ;
			
			
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {


			http.csrf().disable().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
			.and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
			
			TokenFilter tokenFilter = new TokenFilter();
			
			
			http.addFilterAfter(tokenFilter, SecurityContextPersistenceFilter.class);
	 
			
		}
		
		
}
