package com.open.capacity.client.oauth2.service.impl;

import com.open.capacity.client.oauth2.dao.ServiceDao;
import com.open.capacity.client.oauth2.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * API 级别权限认证
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年12月4日 下午5:32:29
 * 类说明
 */

@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    @Resource
    private ServiceDao serviceDao;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Authentication user = SecurityContextHolder.getContext()
                .getAuthentication();


        if (user != null) {

            if (user instanceof OAuth2Authentication) {

                OAuth2Authentication athentication = (OAuth2Authentication) user;

                String clientId = athentication.getOAuth2Request().getClientId();

                Map map = serviceDao.getClient(clientId);

                if (map == null) {
                    return false;
                } else {
                    List<Map> list = serviceDao.listByClientId(Long.valueOf(String.valueOf(map.get("id"))));
                    ;

                    for (Iterator<Map> it = list.iterator(); it.hasNext(); ) {
                        Map temp = it.next();

                        if (antPathMatcher.match(request.getRequestURI(), String.valueOf(temp.get("href")))) {
                            return true;
                        }
                    }
                    return false;
                }


            }

        }


        //TODO 目前都是true
        boolean hasPermission = true;


        return hasPermission;
    }

}
