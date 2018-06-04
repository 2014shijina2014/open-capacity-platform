package com.open.capacity.client.oauth2.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import com.netflix.discovery.CommonConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Created by owen on 2017/9/10.
 */
@Component
public class AccessFilter extends ZuulFilter {

     

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
       
        try {
        	
        	//解决zuul token传递问题
        	Authentication user = SecurityContextHolder.getContext()
                    .getAuthentication();
    		
    		
    		if(user!=null){
    			
    			if(user instanceof OAuth2Authentication){
    				
    				Authentication athentication = (Authentication)user;
    				
    				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) athentication.getDetails() ;
    				ctx.addZuulRequestHeader("Authorization", "bearer "+details.getTokenValue());
    			}
    			
    		}
        	
          
        } catch (Exception e) {
           
        }
        return null;
    }

     
}
