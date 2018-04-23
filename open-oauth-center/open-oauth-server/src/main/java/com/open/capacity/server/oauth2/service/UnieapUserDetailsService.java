package com.open.capacity.server.oauth2.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

 

/** 
* @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
* 类说明 
*/
@Component
public class UnieapUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass()) ;
	
	@Resource
	private PasswordEncoder passwordEncoder ;
	
//	@Resource  注入查询用户的dao
//	private dao
	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("页面输入的用户名："+username);
//		User user = new User(username,"123456",	//默认密码都123456 
//			AuthorityUtils.commaSeparatedStringToAuthorityList("admin")); // 第三个参数是授权的,暂时写硬编码AuthorityUtils.commaSeparatedStringToAuthorityList("admin")
//		
		
//		public User(String username, String password, boolean enabled,
//				boolean accountNonExpired, boolean credentialsNonExpired,
//				boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

		String password = passwordEncoder.encode("123456") ;
		logger.info("数据库存储的密码是:"+password);
		
		
		User user = new User(username,password,	  //123456模拟从数据库中查询得到的
				true,true,true,true, //是否有效，账户是否过期，密码是否过期，是否锁定，
				AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"));
		
		return user;
	}

	 
	 
}
