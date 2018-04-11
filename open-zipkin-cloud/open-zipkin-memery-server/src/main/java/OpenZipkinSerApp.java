

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

/** 
* @author 作者 owen E-mail: wang.wen@neusoft.com
* @version 创建时间：2017年12月4日 下午5:17:00 
* 类说明 
*/
@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class OpenZipkinSerApp {
	public static void main(String[] args) {
		SpringApplication.run(OpenZipkinSerApp.class, args);
	}
}
