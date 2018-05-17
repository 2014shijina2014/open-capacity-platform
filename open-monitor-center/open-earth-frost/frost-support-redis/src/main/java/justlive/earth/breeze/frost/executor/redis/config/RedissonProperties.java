package justlive.earth.breeze.frost.executor.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/**
 * redis配置属性
 * 
 * @author wubo
 *
 */
@Data
@ConfigurationProperties(prefix = "redisson")
@Configuration
public class RedissonProperties {

  /**
   * 超时时间
   */
  private int timeout = 3000;

  /**
   * 地址
   */
  private String address;

  /**
   * 密码
   */
  private String password;

  /**
   * 连接池
   */
  private int connectionPoolSize = 64;

  /**
   * 连接空闲
   */
  private int connectionMinimumIdleSize = 10;

  /**
   * slave连接数
   */
  private int slaveConnectionPoolSize = 250;

  /**
   * master连接数
   */
  private int masterConnectionPoolSize = 250;

  /**
   * 集群地址
   */
  private String[] sentinelAddresses;

}
