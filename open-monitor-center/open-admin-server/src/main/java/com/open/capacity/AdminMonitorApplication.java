package com.open.capacity;


import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年12月8日 上午9:03:32
 * 类说明
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminMonitorApplication.class, args);
        //TODO Spring boot Admin 服务上线下线通知
    }
}
