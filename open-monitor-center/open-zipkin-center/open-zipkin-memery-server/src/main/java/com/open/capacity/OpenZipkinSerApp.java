package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

/** 
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51 类说明
*/
@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class OpenZipkinSerApp {
	public static void main(String[] args) {
		SpringApplication.run(OpenZipkinSerApp.class, args);
	}
}
