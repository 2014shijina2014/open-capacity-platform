package com.open.capacity.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.config.CompositeConfiguration;
import org.springframework.cloud.config.server.config.ConfigServerEncryptionConfiguration;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.config.EnvironmentRepositoryConfiguration;
import org.springframework.cloud.config.server.config.ResourceRepositoryConfiguration;
import org.springframework.cloud.config.server.config.TransportConfiguration;
import org.springframework.context.annotation.Import;

import com.open.capacity.config.ConfigServerMvcConfiguration;

/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年3月31日 下午12:28:53 
* 类说明 
*/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(ConfigServerProperties.class)
@Import({ EnvironmentRepositoryConfiguration.class, //jdbc初始化 客户端根据jdbc加载
		CompositeConfiguration.class, ResourceRepositoryConfiguration.class,
		ConfigServerEncryptionConfiguration.class, 
		ConfigServerMvcConfiguration.class, //webcontroller初始化 服务端定义restful api
		TransportConfiguration.class })
public @interface EnableConfigServer {

}
