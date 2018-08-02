package com.open.capacity.server.oauth2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.server.oauth2.client.RedisClientDetailsService;
import com.open.capacity.server.oauth2.token.store.RedisTemplateTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;

/**
 * 授权服务器配置
 *
 * @author caoheyang
 * @Description:
 * @date 2018/8/211:17
 */
@Configuration
@EnableAuthorizationServer
public class UnieapAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;  //认证管理器

    @Resource
    private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类

    @Autowired
    private UserDetailsService userDetailsService;  //用户信息相关的实现

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
