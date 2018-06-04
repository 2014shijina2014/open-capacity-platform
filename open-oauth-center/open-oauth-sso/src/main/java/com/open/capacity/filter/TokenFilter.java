package com.open.capacity.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Token过滤器
 * 
 * @author owen 624191343@qq.com
 *
 *         2017年10月14日
 */
public class TokenFilter extends OncePerRequestFilter {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication user =  SecurityContextHolder.getContext()
                .getAuthentication();
		
		
		if(user!=null){
			
			if(user instanceof OAuth2Authentication){
				
				Authentication athentication = (Authentication)user;
				
				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) athentication.getDetails() ;
				details.getTokenValue() ;
				 
				initSession(request) ;
				 //重新发起sso登录	OAuth2ClientContextFilter redirectUser(redirect, request, response);
				 
				 
			}
			
		}

//		OAuth2Authentication
		filterChain.doFilter(request, response);
	}

	private void initSession(HttpServletRequest request){
		  Enumeration em = request.getSession().getAttributeNames();
		  while(em.hasMoreElements()){
		   request.getSession().removeAttribute(em.nextElement().toString());
		  }
		 }

}
