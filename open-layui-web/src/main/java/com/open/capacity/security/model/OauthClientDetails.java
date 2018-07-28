package com.open.capacity.security.model;

/**
 * OAUTH2客户端模式表
 *
 * @DBTable oauth_client_details
 */
public class OauthClientDetails extends BaseEntity<Long> {

    private static final long serialVersionUID = -8185413579135897885L;
    //主键
    private Long id;
    //应用标识
    private String clientId;
    //资源限定串(逗号分割)
    private String resourceIds = "";
    //应用密钥(bcyt) 加密
    private String clientSecret;
    //范围
    private String scope = "all";
    //5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
    private String authorizedGrantTypes = "authorization_code,password,refresh_token,client_credentials";
    //回调地址
    private String webServerRedirectUri;
    //权限
    private String authorities = "";
    //access_token有效期
    private Integer accessTokenValidity = 18000;
    //refresh_token有效期
    private Integer refreshTokenValidity = 18000;
    //{}
    private String additionalInformation = "{}";
    //是否自动授权 是-true
    private String autoapprove = "true";

    /**
     * 主键
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用标识
     *
     * @return
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 应用标识
     *
     * @return
     */
    public String setClientId() {
        return clientId;
    }

    /**
     * 资源限定串(逗号分割)
     *
     * @return
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * 资源限定串(逗号分割)
     *
     * @return
     */
    public String setResourceIds() {
        return resourceIds;
    }

    /**
     * 应用密钥(bcyt) 加密
     *
     * @return
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * 应用密钥(bcyt) 加密
     *
     * @return
     */
    public String setClientSecret() {
        return clientSecret;
    }

    /**
     * 范围
     *
     * @return
     */
    public String getScope() {
        return scope;
    }

    /**
     * 范围
     *
     * @return
     */
    public String setScope() {
        return scope;
    }

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     *
     * @return
     */
    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     *
     * @return
     */
    public String setAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /**
     * 回调地址
     *
     * @return
     */
    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * 回调地址
     *
     * @return
     */
    public String setWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    /**
     * 权限
     *
     * @return
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * 权限
     *
     * @return
     */
    public String setAuthorities() {
        return authorities;
    }

    /**
     * access_token有效期
     *
     * @return
     */
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * access_token有效期
     *
     * @return
     */
    public Integer setAccessTokenValidity() {
        return accessTokenValidity;
    }

    /**
     * refresh_token有效期
     *
     * @return
     */
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * refresh_token有效期
     *
     * @return
     */
    public Integer setRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    /**
     * {}
     *
     * @return
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * {}
     *
     * @return
     */
    public String setAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * 是否自动授权 是-true
     *
     * @return
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * 是否自动授权 是-true
     *
     * @return
     */
    public String setAutoapprove() {
        return autoapprove;
    }

}
