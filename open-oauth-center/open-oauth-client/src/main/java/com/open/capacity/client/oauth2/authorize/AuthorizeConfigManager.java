package com.open.capacity.client.oauth2.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21
* 类说明 
*/
public interface AuthorizeConfigManager {

	/**
	 * @param config
	 */
	void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
