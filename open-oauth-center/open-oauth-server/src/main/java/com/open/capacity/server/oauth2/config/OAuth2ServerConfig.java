package com.open.capacity.server.oauth2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.server.oauth2.client.RedisClientDetailsService;
import com.open.capacity.server.oauth2.code.RedisAuthorizationCodeServices;
import com.open.capacity.server.oauth2.token.store.RedisTemplateTokenStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Configuration

public class OAuth2ServerConfig {

    private Logger logger = LoggerFactory.getLogger(OAuth2ServerConfig.class);

    @Resource
    private DataSource dataSource;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 声明 ClientDetails实现
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "security.oauth2.token.store", name = "type", havingValue = "redis", matchIfMissing = true)
    public RedisClientDetailsService clientDetailsService() {
        RedisClientDetailsService clientDetailsService = new RedisClientDetailsService(dataSource);
        clientDetailsService.setRedisTemplate(redisTemplate);
        return clientDetailsService;
    }

    @Bean
    public RandomValueAuthorizationCodeServices authorizationCodeServices() {
        RedisAuthorizationCodeServices redisAuthorizationCodeServices = new RedisAuthorizationCodeServices();
        redisAuthorizationCodeServices.setRedisTemplate(redisTemplate);
        return redisAuthorizationCodeServices;
    }


    /**
     * 授权服务器配置
     */
    @Component
    @Configuration
    @EnableAuthorizationServer
    @AutoConfigureAfter(AuthorizationServerEndpointsConfigurer.class)
    public class UnieapAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

        //注入authenticationManager 来支持 password grant type
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
        private RedisClientDetailsService clientDetailsService;

        @Autowired(required = false)
        private RandomValueAuthorizationCodeServices authorizationCodeServices;

        /**
         * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
         *
         * @param endpoints
         * @throws Exception
         */
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            if (jwtTokenStore != null) {
                endpoints.tokenStore(jwtTokenStore).authenticationManager(authenticationManager)
                        .userDetailsService(userDetailsService); // 支持
            } else if (redisTokenStore != null) {
                endpoints.tokenStore(redisTokenStore).authenticationManager(authenticationManager)
                        .userDetailsService(userDetailsService); // 支持
            }
            if (jwtAccessTokenConverter != null) {
                endpoints.accessTokenConverter(jwtAccessTokenConverter);
            }
            endpoints.authorizationCodeServices(authorizationCodeServices);
            endpoints.exceptionTranslator(webResponseExceptionTranslator);
        }

        /**
         * 配置应用名称 应用id
         * 配置OAuth2的客户端相关信息
         *
         * @param clients
         * @throws Exception
         */
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.withClientDetails(clientDetailsService);
            clientDetailsService.loadAllClientToCache();
        }

        /**
         * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
         *
         * @param security
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security.tokenKeyAccess("permitAll()") /// url:/oauth/token_key,exposes
                    .checkTokenAccess("isAuthenticated()") // url:/oauth/check_token
                    .allowFormAuthenticationForClients();
        }

    }

    /**
     * 资源服务器的配置
     * 实现{@link ResourceServerConfigurerAdapter} 配置需要token验证的资源
     */
    @Configuration
    @EnableResourceServer
    public class ResourceServer extends ResourceServerConfigurerAdapter {

        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/health");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // http.httpBasic() //默认配置
            // 用表单登录
            http.formLogin()
                    // 对请求授权
                    .and().authorizeRequests()
                    .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                    // 所有需要restful保护的资源都需要加入到这个requestMatchers，加入到的资源作为资源服务器保护的资源
                    .and().requestMatchers()
                    .antMatchers("/users", "/**/users").and().authorizeRequests()
                    .antMatchers("/**/users", "/users").authenticated().anyRequest().authenticated() // 所有的请求认证
                    .and().csrf().disable() // 关闭Could not verify the provided
            ;
        }
    }

}
