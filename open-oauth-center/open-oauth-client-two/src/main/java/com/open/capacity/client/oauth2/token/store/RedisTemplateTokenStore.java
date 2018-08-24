package com.open.capacity.client.oauth2.token.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.ExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;

/** 
* @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
* 类说明 
* redis集群存储token
*/
 
public class RedisTemplateTokenStore implements TokenStore {
	
	private static final String ACCESS = "access:";
	private static final String AUTH_TO_ACCESS = "auth_to_access:";
	private static final String AUTH = "auth:";
	private static final String REFRESH_AUTH = "refresh_auth:";
	private static final String ACCESS_TO_REFRESH = "access_to_refresh:";
	private static final String REFRESH = "refresh:";
	private static final String REFRESH_TO_ACCESS = "refresh_to_access:";
	private static final String CLIENT_ID_TO_ACCESS = "client_id_to_access:";
	private static final String UNAME_TO_ACCESS = "uname_to_access:";
	

	private RedisTemplate<String,Object> redisTemplate ;
	
	public RedisTemplate<String,Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


	private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();



	 
	public void setAuthenticationKeyGenerator(AuthenticationKeyGenerator authenticationKeyGenerator) {
		this.authenticationKeyGenerator = authenticationKeyGenerator;
	}

	 
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		String key = authenticationKeyGenerator.extractKey(authentication);
		OAuth2AccessToken accessToken = (OAuth2AccessToken) redisTemplate.opsForValue().get(AUTH_TO_ACCESS+key);
		if (accessToken != null
				&& !key.equals(authenticationKeyGenerator.extractKey(readAuthentication(accessToken.getValue())))) {
			// Keep the stores consistent (maybe the same user is represented by this authentication but the details
			// have changed)
			storeAccessToken(accessToken, authentication);
		}
		return accessToken;
	}
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		return readAuthentication(token.getValue());
	}
	public OAuth2Authentication readAuthentication(String token) {
		return (OAuth2Authentication) this.redisTemplate.opsForValue().get(AUTH +  token);
	}
	public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
		return readAuthenticationForRefreshToken(token.getValue());
	}
	public OAuth2Authentication readAuthenticationForRefreshToken(String token) {
		return (OAuth2Authentication) this.redisTemplate.opsForValue().get( REFRESH_AUTH+token);
	}
	public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
		
		OAuth2AccessToken existingAccessToken = this.getAccessToken(authentication);
		
		this.redisTemplate.opsForValue().set(ACCESS+ token.getValue(), token);
		this.redisTemplate.opsForValue().set(AUTH +token.getValue(), authentication);
		this.redisTemplate.opsForValue().set(AUTH_TO_ACCESS+authenticationKeyGenerator.extractKey(authentication), token);
		
		if (!authentication.isClientOnly()) {
			if (existingAccessToken != null) {
				if (!existingAccessToken.isExpired()) {
					int seconds = token.getExpiresIn();
					redisTemplate.expire(UNAME_TO_ACCESS+authentication.getOAuth2Request().getClientId(), seconds, TimeUnit.SECONDS) ;
				}else{
					redisTemplate.opsForList().rightPush(UNAME_TO_ACCESS+getApprovalKey(authentication), token) ;
				}
			}else{
				redisTemplate.opsForList().rightPush(UNAME_TO_ACCESS+getApprovalKey(authentication), token) ;
			}
					
			
			
		}
		
		
		if (existingAccessToken != null) {
			if (!existingAccessToken.isExpired()) {
				int seconds = token.getExpiresIn();
				redisTemplate.expire(CLIENT_ID_TO_ACCESS+authentication.getOAuth2Request().getClientId(), seconds, TimeUnit.SECONDS) ;
				
			}else{
				redisTemplate.opsForList().rightPush(CLIENT_ID_TO_ACCESS+authentication.getOAuth2Request().getClientId(), token) ;
			}
		}else{
			redisTemplate.opsForList().rightPush(CLIENT_ID_TO_ACCESS+authentication.getOAuth2Request().getClientId(), token) ;
		}
		
		
		
		if (token.getExpiration() != null) {
			  
			int seconds = token.getExpiresIn();
			redisTemplate.expire(ACCESS+ token.getValue(), seconds, TimeUnit.SECONDS) ;
			redisTemplate.expire(AUTH+ token.getValue(), seconds, TimeUnit.SECONDS) ;
			
			redisTemplate.expire(AUTH_TO_ACCESS+ authenticationKeyGenerator.extractKey(authentication), seconds, TimeUnit.SECONDS) ;
			redisTemplate.expire(CLIENT_ID_TO_ACCESS+authentication.getOAuth2Request().getClientId(), seconds, TimeUnit.SECONDS) ;
			redisTemplate.expire(UNAME_TO_ACCESS+ getApprovalKey(authentication), seconds, TimeUnit.SECONDS) ;
		}
		
		OAuth2RefreshToken refreshToken = token.getRefreshToken();
		
		if (token.getRefreshToken() != null && token.getRefreshToken().getValue() != null) {
			this.redisTemplate.opsForValue().set( REFRESH_TO_ACCESS+   token.getRefreshToken().getValue(), token.getValue());
			this.redisTemplate.opsForValue().set(ACCESS_TO_REFRESH+token.getValue(), token.getRefreshToken().getValue());
			
			
			if (refreshToken instanceof ExpiringOAuth2RefreshToken) {
				ExpiringOAuth2RefreshToken expiringRefreshToken = (ExpiringOAuth2RefreshToken) refreshToken;
				Date expiration = expiringRefreshToken.getExpiration();
				if (expiration != null) {
					int seconds = Long.valueOf((expiration.getTime() - System.currentTimeMillis()) / 1000L)
							.intValue();
					
					redisTemplate.expire( REFRESH_TO_ACCESS+   token.getRefreshToken().getValue() , seconds, TimeUnit.SECONDS) ;
					redisTemplate.expire( ACCESS_TO_REFRESH+token.getValue(), seconds, TimeUnit.SECONDS) ;
	 
				}
			}
			
			
		}
	}

	private String getApprovalKey(OAuth2Authentication authentication) {
		String userName = authentication.getUserAuthentication() == null ? "" : authentication.getUserAuthentication()
				.getName();
		return getApprovalKey(authentication.getOAuth2Request().getClientId(), userName);
	}

	private String getApprovalKey(String clientId, String userName) {
		return clientId + (userName==null ? "" : ":" + userName);
	}

	 

	public void removeAccessToken(OAuth2AccessToken accessToken) {
		removeAccessToken(accessToken.getValue());
	}

	public OAuth2AccessToken readAccessToken(String tokenValue) {
		return (OAuth2AccessToken) this.redisTemplate.opsForValue().get(ACCESS+tokenValue);
	}

	public void removeAccessToken(String tokenValue) {
		OAuth2AccessToken removed = (OAuth2AccessToken) redisTemplate.opsForValue().get(ACCESS+tokenValue);
		// Don't remove the refresh token - it's up to the caller to do that
		OAuth2Authentication authentication = (OAuth2Authentication) this.redisTemplate.opsForValue().get(AUTH+tokenValue);
		
		
		this.redisTemplate.delete(AUTH+tokenValue);
		redisTemplate.delete(ACCESS+tokenValue);
		this.redisTemplate.delete(ACCESS_TO_REFRESH +tokenValue);
		
		
		if (authentication != null) {
			this.redisTemplate.delete(AUTH_TO_ACCESS+authenticationKeyGenerator.extractKey(authentication));
		
			String clientId = authentication.getOAuth2Request().getClientId();
			
//			redisTemplate.opsForList().rightPush("UNAME_TO_ACCESS:"+getApprovalKey(authentication), token) ;
			redisTemplate.opsForList().leftPop(UNAME_TO_ACCESS+getApprovalKey(clientId, authentication.getName()));
			
			redisTemplate.opsForList().leftPop(CLIENT_ID_TO_ACCESS+clientId);
			
			this.redisTemplate.delete(AUTH_TO_ACCESS+authenticationKeyGenerator.extractKey(authentication));
		}
	}

	public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
		this.redisTemplate.opsForValue().set(REFRESH+refreshToken.getValue(), refreshToken);
		this.redisTemplate.opsForValue().set( REFRESH_AUTH + refreshToken.getValue(), authentication);
	}

	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		return (OAuth2RefreshToken) this.redisTemplate.opsForValue().get(REFRESH+tokenValue);
	}

	public void removeRefreshToken(OAuth2RefreshToken refreshToken) {
		removeRefreshToken(refreshToken.getValue());
	}

	public void removeRefreshToken(String tokenValue) {
		this.redisTemplate.delete( REFRESH + tokenValue);
		this.redisTemplate.delete( REFRESH_AUTH + tokenValue);
		this.redisTemplate.delete(REFRESH_TO_ACCESS +tokenValue);
	}

	public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
		removeAccessTokenUsingRefreshToken(refreshToken.getValue());
	}

	private void removeAccessTokenUsingRefreshToken(String refreshToken) {
		
		String token = (String) this.redisTemplate.opsForValue().get( REFRESH_TO_ACCESS  +refreshToken) ;
		
		if (token != null) {
			redisTemplate.delete(REFRESH_TO_ACCESS+ refreshToken);
		}
	}

	public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
		List<Object> result =    redisTemplate.opsForList().range(UNAME_TO_ACCESS+ getApprovalKey(clientId, userName), 0, -1);
		
		if (result == null || result.size() == 0) {
			return Collections.<OAuth2AccessToken> emptySet();
		}
		List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>(result.size());
		
		for(Iterator<Object> it = result.iterator();it.hasNext();){
			OAuth2AccessToken accessToken = (OAuth2AccessToken) it.next();
			accessTokens.add(accessToken);
		}
		
		return Collections.<OAuth2AccessToken> unmodifiableCollection(accessTokens); 
	}

	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		List<Object> result =    redisTemplate.opsForList().range((CLIENT_ID_TO_ACCESS+clientId), 0, -1);
		
		if (result == null || result.size() == 0) {
			return Collections.<OAuth2AccessToken> emptySet();
		}
		List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>(result.size());
		
		for(Iterator<Object> it = result.iterator();it.hasNext();){
			OAuth2AccessToken accessToken = (OAuth2AccessToken) it.next();
			accessTokens.add(accessToken);
		}
		
		return Collections.<OAuth2AccessToken> unmodifiableCollection(accessTokens); 
	}

 
 

}

