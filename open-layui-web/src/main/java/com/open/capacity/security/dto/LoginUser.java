package com.open.capacity.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.open.capacity.security.model.SysPermission;
import com.open.capacity.security.model.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 登陆用户
 */
public class LoginUser extends SysUser implements UserDetails {

    private static final long serialVersionUID = -1379274258881257107L;

    //用户资源权限
    private List<SysPermission> permissions;

    //jwt token
    private String jwtToken;

    //token
    private String token;
    /**
     * 登陆时间戳（毫秒）
     */
    private Long loginTime;
    /**
     * 过期时间戳
     */
    private Long expireTime;

    /**
     * 用户资源权限
     * @return
     */
    public List<SysPermission> getPermissions() {
        return permissions;
    }

    /**
     * 用户资源权限
     * @param permissions 资源
     */
    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    /**
     *token
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * token
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 登陆时间
     * @return
     */
    public Long getLoginTime() {
        return loginTime;
    }

    /**
     * 登陆时间
     * @param loginTime
     */
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 过期时间戳
     * @return
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 过期时间戳
     * @param expireTime 过期时间
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * jwt token
     * @return
     */
    @JsonIgnore
    public String getJwtToken() {
        return jwtToken;
    }

    /**
     * jwt token
     * @param jwtToken
     */
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // 重写spring security的方法

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for (Iterator<SysPermission> it = permissions.iterator(); it.hasNext(); ) {
            SysPermission p = it.next();
            if (!StringUtils.isEmpty(p.getPermission())) {
                auths.add(new SimpleGrantedAuthority(p.getPermission()));
            }
        }
        return auths;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        // do nothing
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return getStatus() != Status.LOCKED;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
