package com.open.capacity;


import org.springframework.boot.SpringApplication;
import com.open.capacity.annotation.EnableConfigServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年1月13日 上午9:55:21 类说明 配置中心服务端
 * 需要注册eureka服务器，客户端通过eureka完成负载均衡的配置
 */

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConfigServer {
	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServer.class, args);
	}
}
