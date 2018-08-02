package com.open.capacity.client.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

/**
 * @author keets
 * @date 2017/10/17
 */
@Component
public class OauthLogoutHandler implements LogoutHandler {

    private static final Logger logger = LoggerFactory.getLogger(OauthLogoutHandler.class);

    private static final String LogoutURL1 = "http://127.0.0.1:8000/auth/user/logout?access_token=%s";
    private static final String LogoutURL2 = "http://127.0.0.1:9997/logout";
    
    RedirectStrategy rs = new DefaultRedirectStrategy();
    
//    @Autowired
//    private TokenStore tokenStore;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
 


        if (authentication != null) {

            if (authentication instanceof OAuth2Authentication) {

                Authentication athentication = (Authentication) authentication;

                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) athentication.getDetails();
//                ctx.addZuulRequestHeader("Authorization", "bearer " + details.getTokenValue());
                
                try {
					rs.sendRedirect(request, response, String.format(LogoutURL1, details.getTokenValue()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }
        }
    }

     

}
