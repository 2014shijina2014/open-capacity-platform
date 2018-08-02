package com.open.capacity.client.config;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author keets
 * @date 2017/10/17
 */
@Component
public class OauthLogoutHandler implements LogoutHandler {

    private static final Logger logger = LoggerFactory.getLogger(OauthLogoutHandler.class);

    private static final String LogoutURL1 = "http://127.0.0.1:8000/auth/user/logout?access_token=%s";
    private static final String LogoutURL2 = "http://127.0.0.1:9997/logout";
    
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
					CloseableHttpClient httpClient = HttpClients.createDefault();
					// 创建http POST请求
					HttpGet httpGet = new HttpGet(String.format(LogoutURL1, details.getTokenValue()));
					// HttpGet httpGet = new HttpGet(url);
					// URL url = new URL(BASE_URL);
					// 创建http POST请求
					
					
					HttpGet httpGet2 = new HttpGet(String.format(LogoutURL1, details.getTokenValue()));
					
					CloseableHttpResponse resp = null;
					try {
						// 执行请求
						resp = httpClient.execute(httpGet);
						// 判断返回状态是否为200
						resp = httpClient.execute(httpGet2);
						String content = EntityUtils.toString(resp.getEntity(), "UTF-8");

					}  catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (response != null) {
							resp.close();
						}

						httpClient.close();
					}
					
					
					 
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }

        }

    }

     

}
