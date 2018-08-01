package com.open.capacity.security.utils;

import com.open.capacity.security.dto.LoginUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Spring Security 用户帮助类
 *
 * @author caoheyang
 * @version 20180727
 */
public class UserUtil {


    /**
     * 获取登陆用户
     *
     * @return 登陆用户
     */
    public static LoginUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (LoginUser) authentication.getPrincipal();
            }
        }
        return null;
    }

}
