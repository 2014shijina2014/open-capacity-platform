package com.open.capacity.server.oauth2.config;

/**
 * 作为资源服务器的配置
 * @author caoheyang
 * @Description:
 * @date 2018/8/211:31
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

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
                .and().requestMatchers()   // 所有需要restful保护的资源都需要加入到这个requestMatchers，加入到的资源作为资源服务器保护的资源
                .antMatchers("/users", "/**/users").and().authorizeRequests()
                .antMatchers("/**/users", "/users").authenticated().anyRequest().authenticated() // 所有的请求认证
                .and().csrf().disable() // 关闭Could not verify the provided
        ;
    }
}
