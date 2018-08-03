package com.open.capacity.client.oauth2.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 白名单
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年2月1日 下午9:47:00
 */
public interface AuthorizeConfigManager {

    /**
     * @param config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
