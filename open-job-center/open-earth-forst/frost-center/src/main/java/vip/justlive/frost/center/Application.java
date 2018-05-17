package vip.justlive.frost.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import vip.justlive.common.web.base.CodedExceptionResolver;

/**
 * 启动器
 * 
 * @author wubo
 *
 */
@SpringBootApplication(scanBasePackages = "vip.justlive.frost")
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(Application.class);
  }

  @Bean
  CodedExceptionResolver codedExceptionResolver() {
    return new CodedExceptionResolver();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
