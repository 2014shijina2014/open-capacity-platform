package com.open.capacity.security.service;

import com.open.capacity.security.dao.SysPermissionDao;
import com.open.capacity.security.dto.LoginUser;
import com.open.capacity.security.model.SysPermission;
import com.open.capacity.security.model.SysUser;
import com.open.capacity.security.model.SysUser.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spring security登陆处理
 * <p>实现spring security UserDetailsService接口，重写spring security获取用户的方式</p>
 *
 * @author owen 624191343@qq.com
 */
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private SysPermissionDao sysPermissionDao;


    /**
     * 重写spring security loadUserByUsername 方法
     *
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUser(username);
        if (sysUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        } else if (sysUser.getStatus() == Status.LOCKED) {
            throw new LockedException("用户被锁定,请联系管理员");
        } else if (sysUser.getStatus() == Status.DISABLED) {
            throw new DisabledException("用户已作废");
        }

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(sysUser, loginUser);

        List<SysPermission> permissions = sysPermissionDao.listByUserId(sysUser.getId());
        loginUser.setPermissions(permissions);
        return loginUser;
    }
}
