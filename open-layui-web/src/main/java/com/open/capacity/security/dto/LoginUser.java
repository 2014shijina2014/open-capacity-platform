package com.open.capacity.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.open.capacity.security.model.Permission;
import com.open.capacity.security.model.SysUser;

public class LoginUser extends SysUser implements UserDetails {

	private static final long serialVersionUID = -1379274258881257107L;

	private List<Permission> permissions;
	private String token;
	/** 登陆时间戳（毫秒） */
	private Long loginTime;
	/** 过期时间戳 */
	private Long expireTime;

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		for(Iterator<Permission> it = permissions.iterator();it.hasNext();){
			Permission p = it.next();
			
			
			if(  !StringUtils.isEmpty(p.getPermission()) ){
				auths.add(new SimpleGrantedAuthority(p.getPermission()));
			}
		}
		
		return auths ;
		
//		return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
//				.map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());
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

	// 账户是否激活
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

}
