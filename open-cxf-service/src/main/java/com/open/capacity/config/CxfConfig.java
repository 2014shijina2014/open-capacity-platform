package com.open.capacity.config;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.chinaunicom.ws.srenewser.SrenewSer;
import cn.chinaunicom.ws.srenewser.SrenewSerImpl;

/**
 * @author 作者 owen E-mail: wang.wen@neusoft.com
 * @version 创建时间：2017年7月18日 上午9:01:06 类说明
 */

@Configuration
public class CxfConfig {
	
	@Resource
	private AutowireCapableBeanFactory autowireCapableBeanFactory ;
	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/services/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public SrenewSer srenewSer() {
		
		SrenewSer srenewSer = new SrenewSerImpl() ;
		return srenewSer;
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), srenewSer());
		endpoint.publish("/srenewSerSOAP");
		return endpoint;
	}
}
