/**
 * 
 */
package com.open.capacity.client.oauth2.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import com.open.capacity.client.oauth2.service.RbacService;
 
/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年4月5日 下午19:52:21
* 类说明 
*   @param request        HttpServletRequest
*   @param authentication 认证信息
*   @return 是否有权限
*/

@Service("rbacService")
public class RbacServiceImpl implements RbacService {

	private AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		Object principal = authentication.getPrincipal();

		boolean hasPermission = true;

		
		
		return hasPermission;
	}

}
