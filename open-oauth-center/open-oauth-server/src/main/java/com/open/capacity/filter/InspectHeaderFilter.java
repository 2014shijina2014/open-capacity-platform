package com.open.capacity.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


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
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}