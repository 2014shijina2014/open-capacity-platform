package com.open.capacity ;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;


/** 
* @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月28日 下午22:50:29 
* 类说明 
* eureka高可用三台机器
*/
@EnableEurekaServer
//@EnableEurekaClient
@SpringBootApplication
public class EurekaServerApp {
    public static void main(String[] args) {
    	
//    	1本地启动采用此方法加载profiles文件
//		ConfigurableApplicationContext context = new SpringApplicationBuilder(UnieapEurekaServerApplication.class).
//				profiles("slave3").run(args);
    	
//    	2服务器采用此方法 java -jar   --spring.profiles.active=slave3;
//    	 SpringApplication.run(DreiEurekaServerApp.class, args);
    	ConfigurableApplicationContext context = new SpringApplicationBuilder(EurekaServerApp.class).
				profiles("slave0").run(args);
    }
}
