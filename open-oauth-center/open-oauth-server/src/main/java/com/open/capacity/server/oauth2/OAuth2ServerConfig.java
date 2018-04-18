
package com.open.capacity.server.oauth2;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.server.oauth2.token.store.RedisTemplateTokenStore;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Configuration
public class OAuth2ServerConfig {

	private Logger logger =LoggerFactory.getLogger(OAuth2ServerConfig.class) ;
	
	@Resource
	private DataSource dataSource;
	
	@Bean // 声明 ClientDetails实现
	@ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
	public ClientDetailsService clientDetailsService() {
		return new JdbcClientDetailsService(dataSource);
	}
	
	/**
	 * @author 作者 owen E-mail: wang.wen@neusoft.com
	 * @version 创建时间：2017年10月30日 上午9:45:12 类说明 默认token存储在内存中
	 *          DefaultTokenServices默认处理
	 */
	@Component
	@Configuration
	@EnableAuthorizationServer
	public   class UnieapAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
		/**
		 * 注入authenticationManager 来支持 password grant type
		 */
		@Autowired
		private AuthenticationManager authenticationManager;

		@Resource
		private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类

		@Autowired
		private UserDetailsService userDetailsService;
		@Autowired(required = false)
		private RedisTemplateTokenStore redisTokenStore;

		@Autowired(required = false)
		private JwtTokenStore jwtTokenStore;
		@Autowired(required = false)
		private JwtAccessTokenConverter jwtAccessTokenConverter;

		@Autowired
		private WebResponseExceptionTranslator webResponseExceptionTranslator;

		@Autowired
		private ClientDetailsService clientDetailsService ;
		

		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

			
			logger.info("redisTokenStore===================" + redisTokenStore);
			
			if (jwtTokenStore != null) {
				endpoints.tokenStore(jwtTokenStore).authenticationManager(authenticationManager)
						.userDetailsService(userDetailsService); // 支持
				// password
				// grant
				// type;
			} else if (redisTokenStore != null) {
				endpoints.tokenStore(redisTokenStore).authenticationManager(authenticationManager)
						.userDetailsService(userDetailsService); // 支持
				// password
				// grant
				// type;
			}

			if (jwtAccessTokenConverter != null) {
				endpoints.accessTokenConverter(jwtAccessTokenConverter);
			}
			endpoints.exceptionTranslator(webResponseExceptionTranslator);

		}

		// 配置应用名称 应用id
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

			// if(clientDetailsService!=null){
			// clients.withClientDetails(clientDetailsService);
			// }else{
			// clients.inMemory().withClient("neusoft1").secret("neusoft1")
			// .authorizedGrantTypes("authorization_code", "password",
			// "refresh_token").scopes("all")
			// .resourceIds(SERVER_RESOURCE_ID).accessTokenValiditySeconds(1200)
			// .refreshTokenValiditySeconds(50000)
			// .and().withClient("neusoft2").secret("neusoft2")
			// .authorizedGrantTypes("authorization_code", "password",
			// "refresh_token").scopes("all")
			// .resourceIds(SERVER_RESOURCE_ID).accessTokenValiditySeconds(1200)
			// .refreshTokenValiditySeconds(50000)
			// ;
			// }
			clients.withClientDetails(clientDetailsService);

		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

			security.tokenKeyAccess("permitAll()") /// url:/oauth/token_key,exposes
													/// public key for token
													/// verification if using
													/// JWT tokens
					.checkTokenAccess("isAuthenticated()") // url:/oauth/check_token
															// allow check token
					.allowFormAuthenticationForClients();

			// security.allowFormAuthenticationForClients();
			//// security.tokenKeyAccess("permitAll()");
			// security.tokenKeyAccess("isAuthenticated()");
		}

	}

	// add for sso
	// 在ResourceServerConfigurerAdapter配置需要token验证的资源
	@Configuration
	@EnableResourceServer
	public class ResourceServer extends ResourceServerConfigurerAdapter {
		@Override
		public void configure(HttpSecurity http) throws Exception {


			// http.httpBasic() //默认配置
			// 用表单登录
			http.formLogin()
					// 对请求授权
					.and().authorizeRequests()
					// 所有需要restful保护的资源都需要加入到这个requestMatchers，加入到的资源作为资源服务器保护的资源
					.and().requestMatchers().antMatchers("/users", "/**/users").and().authorizeRequests()
					.antMatchers("/**/users", "/users").authenticated().anyRequest().authenticated() // 所有的请求认证
					.and().csrf().disable() // 关闭Could not verify the provided
											// CSRF
											// token because your session was
											// not
											// found
			;
		}
	}

}
