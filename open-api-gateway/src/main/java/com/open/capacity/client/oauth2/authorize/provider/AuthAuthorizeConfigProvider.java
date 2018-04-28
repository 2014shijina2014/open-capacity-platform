package com.open.capacity.client.oauth2.authorize.provider;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.open.capacity.client.oauth2.authorize.AuthorizeConfigProvider;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年1月31日 下午9:11:36 
* 类说明 
* 白名单
*/
@Component
@Order(Integer.MAX_VALUE - 1)
public class AuthAuthorizeConfigProvider implements AuthorizeConfigProvider {

	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		 
		//免token登录设置
		config.antMatchers("/test163").permitAll();
		config.antMatchers("/auth/**").permitAll();
		config.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll() ;
		config.antMatchers("/**/v2/api-docs", "/**/configuration/ui", "/**/swagger-resources", "/**/configuration/security", "/**/swagger-ui.html", "/**/webjars/**").permitAll() ;
		
	
		return true;
	}

}
