package com.open.capacity.apollo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2018年2月23日 下午10:29:25 类说明
 */
@Configuration
@ConditionalOnProperty(name = "zuul.store", havingValue = "config", matchIfMissing = false)
public class ZuulConfig {
	
	@Autowired
	private ZuulConfig  zuulConfig ;
	
	@Autowired
	private RefreshScope  refreshScope ;

	@EnableApolloConfig
	public static class ApolloConfig {
		@Bean(name = "zuul.CONFIGURATION_PROPERTIES")
		@org.springframework.cloud.context.config.annotation.RefreshScope
		@ConfigurationProperties("zuul")
		@Primary
		public ZuulProperties zuulProperties() {
			return new ZuulProperties();
		}

	}

	
	@Component
	public  class ZuulConfigRreshConfig {

		
		
		@ApolloConfigChangeListener
		public void onChange(ConfigChangeEvent changEvent){
			refreshScope.refresh("zuul.CONFIGURATION_PROPERTIES") ;
		}
	}
	
}
