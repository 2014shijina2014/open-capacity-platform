package com.open.capacity.server.oauth2.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author keets
 * @date 2017/10/17
 */
public class OauthLogoutHandler implements LogoutHandler {

	private static final Logger logger = LoggerFactory.getLogger(OauthLogoutHandler.class);

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Assert.notNull(tokenStore, "tokenStore must be set");
		String token = extractToken(request);
		Assert.hasText(token, "token must be set");
		OAuth2AccessToken existingAccessToken = tokenStore.readAccessToken(token);
		OAuth2RefreshToken refreshToken;
		if (existingAccessToken != null) {
			if (existingAccessToken.getRefreshToken() != null) {
				logger.info("remove refreshToken!", existingAccessToken.getRefreshToken());
				refreshToken = existingAccessToken.getRefreshToken();
				tokenStore.removeRefreshToken(refreshToken);
			}
			logger.info("remove existingAccessToken!", existingAccessToken);
			tokenStore.removeAccessToken(existingAccessToken);
		}
		return;

	}

	protected String extractToken(HttpServletRequest request) {
		// first check the header...
		String token = extractHeaderToken(request);

		// bearer type allows a request parameter as well
		if (token == null) {
			logger.debug("Token not found in headers. Trying request parameters.");
			token = request.getParameter(OAuth2AccessToken.ACCESS_TOKEN);
			if (token == null) {
				logger.debug("Token not found in request parameters.  Not an OAuth2 request.");
			} else {
				request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, OAuth2AccessToken.BEARER_TYPE);
			}
		}

		return token;
	}

	protected String extractHeaderToken(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaders("Authorization");
		while (headers.hasMoreElements()) { // typically there is only one (most
											// servers enforce that)
			String value = headers.nextElement();
			if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
				String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
				// Add this here for the auth details later. Would be better to
				// change the signature of this method.
				request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE,
						value.substring(0, OAuth2AccessToken.BEARER_TYPE.length()).trim());
				int commaIndex = authHeaderValue.indexOf(',');
				if (commaIndex > 0) {
					authHeaderValue = authHeaderValue.substring(0, commaIndex);
				}
				return authHeaderValue;
			}
		}

		return null;
	}

}
