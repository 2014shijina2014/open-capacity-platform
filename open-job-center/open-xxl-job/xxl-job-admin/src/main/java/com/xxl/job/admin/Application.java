package com.xxl.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ccb on 2017/1/20.
 */


@SpringBootApplication
@ComponentScan(basePackages={"com.xxl.job.admin","com.open.capacity"})
@PropertySource(value = "classpath:xxl-job-admin.properties")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}