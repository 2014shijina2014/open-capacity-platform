package com.open.capacity.server.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * spring security配置
 * 
 * @author owen 624191343@qq.com
 * 
 *         2017年10月16日
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
//	@Autowired
//	private LogoutSuccessHandler logoutSuccessHandler;
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private UserDetailsService userDetailsService;
 
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// 基于token，所以不需要session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests()
//			.antMatchers("/oauth/token").denyAll() 
		.anyRequest().authenticated();
		http.formLogin().loginProcessingUrl("/user/token")
				.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
//		http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
		// 解决不允许显示在iframe的问题
		http.headers().frameOptions().disable();
		http.headers().cacheControl();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}
