package com.open.capacity.dynamic.config.routers; 

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.open.capacity.dynamic.data.ZuulRouteVO;  
  
/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年2月24日 下午8:17:58 
* 类说明 
*/
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {  
  
    public final static Logger logger = LoggerFactory.getLogger(CustomRouteLocator.class);  
  
    private JdbcTemplate jdbcTemplate;  
  
    private ZuulProperties properties;  
  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }  
  
    public CustomRouteLocator(String servletPath, ZuulProperties properties) {  
        super(servletPath, properties);  
        this.properties = properties;  
        logger.info("servletPath:{}", servletPath);  
    }  
  
    //父类已经提供了这个方法，这里写出来只是为了说明这一个方法很重要！！！  
//    @Override  
//    protected void doRefresh() {  
//        super.doRefresh();  
//    }  
  
  
    @Override  
    public void refresh() {  
        doRefresh();  
    }  
  
    @Override  
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {  
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();  
        //从application.properties中加载路由信息  
        routesMap.putAll(super.locateRoutes());  
        //从db中加载路由信息  
        routesMap.putAll(locateRoutesFromDB());  
        //优化一下配置  
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();  
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {  
            String path = entry.getKey();  
            // Prepend with slash if not already present.  
            if (!path.startsWith("/")) {  
                path = "/" + path;  
            }  
            if (StringUtils.hasText(this.properties.getPrefix())) {  
                path = this.properties.getPrefix() + path;  
                if (!path.startsWith("/")) {  
                    path = "/" + path;  
                }  
            }  
            values.put(path, entry.getValue());  
        }  
        return values;  
    }  
  
    private Map<String, ZuulProperties.ZuulRoute> locateRoutesFromDB() {  
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();  
        List<ZuulRouteVO> results = jdbcTemplate.query("select * from gateway_api_define where enabled = true ", new  
                BeanPropertyRowMapper<>(ZuulRouteVO.class));  
        for (ZuulRouteVO result : results) {  
            if (StringUtils.isEmpty(result.getPath()) ) {  
                continue;  
            }  
            if (StringUtils.isEmpty(result.getServiceId()) && StringUtils.isEmpty(result.getUrl())) {  
                continue;  
            }  
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();  
            try {  
                BeanUtils.copyProperties(result, zuulRoute);  
            } catch (Exception e) {  
                logger.error("=============load zuul route info from db with error==============", e);  
            }  
            routes.put(zuulRoute.getPath(), zuulRoute);  
        }  
        return routes;  
    }  
}