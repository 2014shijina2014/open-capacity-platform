
package com.open.capacity.client.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.capacity.client.oauth2.authorize.AuthorizeConfigManager;
import com.open.capacity.client.oauth2.filter.IPFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
 */
@Component
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ClientConfig extends ResourceServerConfigurerAdapter {

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
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;
    @Autowired
    private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/health");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        if (jwtTokenStore != null) {
            resources.tokenStore(jwtTokenStore);
        } else if (redisTokenStore != null) {
            resources.tokenStore(redisTokenStore);
        }
        resources.stateless(true);

        resources.authenticationEntryPoint(authenticationEntryPoint);

        resources.expressionHandler(expressionHandler);
        resources.accessDeniedHandler(oAuth2AccessDeniedHandler);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();

        authorizeConfigManager.config(http.authorizeRequests());

        IPFilter iPFilter = new IPFilter();
        iPFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        iPFilter.afterPropertiesSet();

        http.addFilterAfter(iPFilter, SecurityContextPersistenceFilter.class);

    }

}
