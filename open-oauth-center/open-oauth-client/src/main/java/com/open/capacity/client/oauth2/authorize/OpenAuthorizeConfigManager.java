package com.open.capacity.client.oauth2.authorize;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21
* 类说明 
*/
@Component
public class OpenAuthorizeConfigManager implements AuthorizeConfigManager {

	@Autowired
	private List<AuthorizeConfigProvider> authorizeConfigProviders;

	/* (non-Javadoc)
	 * @see com.imooc.security.core.authorize.AuthorizeConfigManager#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
	 */
	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		 
		//设置访问
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			authorizeConfigProvider.config(config) ;
		}
		config
		.anyRequest()
			.access("@rbacService.hasPermission(request, authentication)");
	}

}
