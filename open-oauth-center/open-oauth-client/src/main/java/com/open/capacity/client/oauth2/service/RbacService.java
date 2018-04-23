/**
 * 
 */
package com.open.capacity.client.oauth2.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21
* 类说明 
*/
public interface RbacService {
	
	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
