package com.open.capacity.dynamic.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.dynamic.service.RefreshRouteService;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2018年2月24日 下午8:25:08 
* 类说明 
*/

@RestController  
public class RefreshController {  
    @Autowired  
    private RefreshRouteService refreshRouteService;  
    @Autowired  
    private ZuulHandlerMapping zuulHandlerMapping;  
  
    @GetMapping("/refreshRoute")  
    public String refresh() {  
        refreshRouteService.refreshRoute();  
        return "refresh success";  
    }  
  
    @RequestMapping("/watchRoute")  
    public Object watchNowRoute() {  
        //可以用debug模式看里面具体是什么  
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();  
        return handlerMap;  
    }  
  
}  

