package com.open.capacity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger文档
 * 
* @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年3月20日 下午10:13:18 类说明
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("swagger接口文档")
				.apiInfo(new ApiInfoBuilder().title("swagger接口文档")
						.contact(new Contact("owen", "", "624191343@qq.com")).version("1.0").build())
				.select().paths(PathSelectors.any()).build();
	}
}
