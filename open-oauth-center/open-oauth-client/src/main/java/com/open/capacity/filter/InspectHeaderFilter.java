package com.open.capacity.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

 

@Component
public class InspectHeaderFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(InspectHeaderFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.debug("得到头信息中的Authorization: " + httpServletRequest.getHeader("Authorization"));
        
//        String header = httpServletRequest.getHeader("Authorization") ;
//        String token = StringUtils.substringAfter(header, "bearer ") ;
//        
//        Claims claims =  Jwts.parser().setSigningKey("neusoft".getBytes("UTF-8")).parseClaimsJws(token).getBody() ;
//
//        logger.debug("claims: " + claims);
        
        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}