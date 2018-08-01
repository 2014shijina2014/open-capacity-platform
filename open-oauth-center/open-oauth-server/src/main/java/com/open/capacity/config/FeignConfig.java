package com.open.capacity.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * feign的请求前置处理
 *
 * @author caoheyang
 * @version 20170731
 * @deception 创建自定义请求拦截器，在发送请求前增加了一个请求头信息，进行身份校验
 */
@Component
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String TOKEN_KEY = "access_token";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("access_token", getToken(getHttpServletRequest()));
    }

    /**
     * 获取当前请求上下文的HttpServletRequest
     *
     * @return HttpServletRequest
     */
    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据参数或者header获取token
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getParameter(TOKEN_KEY);
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(TOKEN_KEY);
        }
        return token;
    }
}
