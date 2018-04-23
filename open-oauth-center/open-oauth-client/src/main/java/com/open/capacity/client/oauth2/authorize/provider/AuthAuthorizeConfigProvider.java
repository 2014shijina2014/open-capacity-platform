package com.open.capacity.client.oauth2.authorize.provider;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.open.capacity.client.oauth2.authorize.AuthorizeConfigProvider;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21 
* 类说明 
*/
@Component
@Order(Integer.MAX_VALUE - 1)
public class AuthAuthorizeConfigProvider implements AuthorizeConfigProvider {

	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		 
		config.anyRequest().authenticated() ;
		return true;
	}

}
