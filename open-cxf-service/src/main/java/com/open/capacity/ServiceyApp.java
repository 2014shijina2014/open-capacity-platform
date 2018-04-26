package com.open.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.open.capacity.utils.SpringUtil;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */
@SpringBootApplication
public class ServiceyApp {
	 
	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(ServiceyApp.class, args);
		//打印密码配置到application.yml   ENC(3XnKRy8g7S01aToLXquCSZQPNeeaEzvS)中
		context.getBean(SpringUtil.class).encryptPwd();
	 
	}
}
