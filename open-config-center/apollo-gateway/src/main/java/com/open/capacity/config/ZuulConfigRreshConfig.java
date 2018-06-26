package com.open.capacity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.core.dto.ApolloConfig;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年3月7日 下午10:56:13 
* 类说明 
*/
@Component
public class ZuulConfigRreshConfig {

	@Autowired
	private ZuulConfig  zuulConfig ;
	
	@Autowired
	private RefreshScope  refreshScope ;
	
	
	@ApolloConfigChangeListener
	public void onChange(ConfigChangeEvent changEvent){
		refreshScope.refresh("zuul.CONFIGURATION_PROPERTIES") ;
	}
}
