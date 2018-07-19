package com.open.capacity.client.oauth2.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年12月4日 下午5:32:29
 * 类说明
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
