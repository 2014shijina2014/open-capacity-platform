package com.open.capacity.client.oauth2.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/** 
* @author 作者 owen E-mail:624191343@qq.com
* @version 创建时间：2018年2月1日 下午9:46:25 
* 类说明 
*/
public interface AuthorizeConfigProvider {

	boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
