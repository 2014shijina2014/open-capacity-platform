package com.ctrip.framework.apollo.portal;

import com.ctrip.framework.apollo.common.ApolloCommonConfig;
import com.ctrip.framework.apollo.openapi.PortalOpenApiConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.actuate.system.EmbeddedServerPortFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@Configuration
@PropertySource(value = {"classpath:portal.properties"})
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {ApolloCommonConfig.class,
    PortalApplication.class, PortalOpenApiConfig.class})
public class PortalApplication {

  public static void main(String[] args) throws Exception {
    ConfigurableApplicationContext context = SpringApplication.run(PortalApplication.class, args);
    context.addApplicationListener(new ApplicationPidFileWriter());
    context.addApplicationListener(new EmbeddedServerPortFileWriter());
  }
}
