/**
 *
 */
package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年4月5日 下午19:52:21
 * 类说明
 */


@Configuration
@EnableDiscoveryClient
@SpringBootApplication
public class UnieapAuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(UnieapAuthServerApp.class, args);
    }

}
