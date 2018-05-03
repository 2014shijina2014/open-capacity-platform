package com.open.capacity.security.model;



public class OauthClientDetails extends BaseEntity<Long> {

	private Long id ;
	private String clientId;
	private String resourceIds = "";
	private String clientSecret;
	private String scope ="all";
	private String authorizedGrantTypes ="authorization_code,password,refresh_token,client_credentials";
	private String webServerRedirectUri;
	private String authorities ="";
	private Integer accessTokenValidity = 18000;
	private Integer refreshTokenValidity = 18000;
	private String additionalInformation ="";
	private String autoapprove ="1";

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public String setClientId() {
		return clientId;
	}
	public String getResourceIds() {
		return resourceIds;
	}
	public String setResourceIds() {
		return resourceIds;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public String setClientSecret() {
		return clientSecret;
	}
	public String getScope() {
		return scope;
	}
	public String setScope() {
		return scope;
	}
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public String setAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}
	public String setWebServerRedirectUri() {
		return webServerRedirectUri;
	}
	public String getAuthorities() {
		return authorities;
	}
	public String setAuthorities() {
		return authorities;
	}
	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}
	public Integer setAccessTokenValidity() {
		return accessTokenValidity;
	}
	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}
	public Integer setRefreshTokenValidity() {
		return refreshTokenValidity;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public String setAdditionalInformation() {
		return additionalInformation;
	}
	public String getAutoapprove() {
		return autoapprove;
	}
	public String setAutoapprove() {
		return autoapprove;
	}

}
