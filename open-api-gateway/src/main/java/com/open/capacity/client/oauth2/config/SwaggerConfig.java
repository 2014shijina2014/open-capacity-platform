package com.open.capacity.client.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Component
@Configuration  
@EnableSwagger2  
public class SwaggerConfig  {  
    @Bean  
    public Docket api() {  
        return new Docket(DocumentationType.SWAGGER_2)  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.open.capacity"))
                .apis(RequestHandlerSelectors.any())  
                .paths(PathSelectors.any())  
                .build();  
    }  
    
   
   
}  