package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/** 
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51 类说明
* 类说明 
*/
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinStreamServer
public class OpenZipkinServer {
	public static void main(String[] args) {
		SpringApplication.run(OpenZipkinServer.class, args);
	}

}
