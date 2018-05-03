package com.open.capacity; 


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2018年3月7日 下午4:44:46 
* 类说明 
*/


@RestController
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGateWayApp {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApp.class, args);
	}
}


 

 