package com.open.capacity.dynamic.service; 
/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年2月24日 下午8:23:47 
* 类说明 
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;  
  
@Service  
public class RefreshRouteService {  
    @Autowired  
    private ApplicationEventPublisher publisher;  
  
    @Autowired  
    private RouteLocator routeLocator;  
  
    public void refreshRoute() {  
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);  
        publisher.publishEvent(routesRefreshedEvent);  
    }  
}  