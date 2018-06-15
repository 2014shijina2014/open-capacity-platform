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
 * API 级别权限认证
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年12月4日 下午5:32:29
 * 类说明
 */

@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        //TODO 目前都是true
        boolean hasPermission = true;


        return hasPermission;
    }

}
