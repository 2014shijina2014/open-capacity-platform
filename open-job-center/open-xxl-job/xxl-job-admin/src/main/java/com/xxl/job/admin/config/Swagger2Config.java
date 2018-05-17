/**
 * @Copyright ®2017 Sinosoft Co. Ltd. All rights reserved.<br/>
 * 项目名称 : 交银康联智能运营平台
 * 创建日期 : 2017年5月24日
 * 修改历史 : 
 *     1. [2017年5月24日]创建文件 by sinosoft
 */
package com.xxl.job.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration注解　加载此类配置
 * EnableSwagger2注解　启用Swagger2
 * @author sinfosoft
 * @date 2017年5月24日 下午5:47:11 
 * @version V1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) //创建API基本信息
                .groupName("") //指定分组，对应(/v2/api-docs?group=)
                .pathMapping("") //base地址，最终会拼接Controller中的地址
                .select() //控制要暴露的接口
                .apis(RequestHandlerSelectors.basePackage("com.shaoytsh.spinrgbootwebproject.controller")) //通过指定扫描包暴露接口
                .paths(PathSelectors.any()) //设置过滤规则暴露接口
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("job RESTful APIs").description("业务服务").termsOfServiceUrl("")
                .contact(new Contact("shaoytsh", "http://shaoytsh.cn/", "shyttsyj@126.com")).version("1.0").license("").licenseUrl("").build();
    }
}
