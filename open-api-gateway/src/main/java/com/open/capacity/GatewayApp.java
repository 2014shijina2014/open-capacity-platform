package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年12月2日 下午7:11:57 类说明 #从config
 *          server的trunk拉取unieap-config-client-dev.yml文件
 *          bootstrap的spring.application.name-profiles
 *
 *          spring: cloud: config: uri: http://192.168.3.2:8888 uri
 *          改变默认充本机localohostL8888拉取配置
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApp {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	//前后分离 ajax跨域调用处理
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // 允许cookies跨域
		config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080
										// ,以降低安全风险。。
		config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
		config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
		config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
		/*
		 * config.addAllowedMethod("HEAD"); config.addAllowedMethod("GET");//
		 * 允许Get的请求方法 config.addAllowedMethod("PUT");
		 * config.addAllowedMethod("POST"); config.addAllowedMethod("DELETE");
		 * config.addAllowedMethod("PATCH");
		 */
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	public static void main(String[] args) {

		SpringApplication.run(GatewayApp.class, args);
	}
}
