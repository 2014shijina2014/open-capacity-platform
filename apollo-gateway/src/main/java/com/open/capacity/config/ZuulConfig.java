package com.open.capacity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年2月23日 下午10:29:25 
* 类说明 
*/
@Configuration
@EnableApolloConfig
public class ZuulConfig  {

    @Bean(name="zuul.CONFIGURATION_PROPERTIES")
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
