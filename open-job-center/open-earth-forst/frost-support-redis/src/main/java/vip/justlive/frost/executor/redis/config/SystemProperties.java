package vip.justlive.frost.executor.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/**
 * 系统属性
 * 
 * @author wubo
 *
 */
@Data
@ConfigurationProperties(prefix = "system")
@Configuration
public class SystemProperties {

  /**
   * 线程池中最小线程数
   */
  private Integer corePoolSize = 5;

  /**
   * 最大线程数
   */
  private Integer maximumPoolSize = 50;

  /**
   * 空闲线程待机时间
   */
  private Integer keepAliveTime = 300;

  /**
   * 待执行线程队列
   */
  private Integer queueCapacity = 200;
  
  private Integer workers = 10;

}
