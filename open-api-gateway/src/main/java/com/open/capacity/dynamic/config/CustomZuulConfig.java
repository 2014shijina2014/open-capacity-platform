package com.open.capacity.dynamic.config; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.open.capacity.dynamic.config.routers.CustomRouteLocator;  


/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年2月24日 下午8:20:39 
* 类说明 
* 里面主要是一个方法，locateRoutes方法，该方法就是zuul设置路由规则的地方，在方法里做了2件事，一是从application.yml读取配置的路由信息，二是从数据库里读取路由信息，所以数据库里需要一个各字段和ZuulProperties.ZuulRoute一样的表，存储路由信息，从数据库读取后添加到系统的Map<String, ZuulProperties.ZuulRoute>中。
在实际的路由中，zuul就是按照Map<String, ZuulProperties.ZuulRoute>里的信息进行路由转发的
*/
@Configuration  
@ConditionalOnProperty(name = "zuul.store", havingValue = "jdbc" , matchIfMissing = true )
public class CustomZuulConfig {  
  
    @Autowired  
    ZuulProperties zuulProperties;  
    @Autowired  
    ServerProperties server;  
    @Autowired  
    JdbcTemplate jdbcTemplate;  
  
    @Bean  
    //没有默认jdbc方式处理
    public CustomRouteLocator routeLocator() {  
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);  
        routeLocator.setJdbcTemplate(jdbcTemplate);  
        return routeLocator;  
    }  
  
}  
