package justlive.earth.breeze.frost.executor.redis.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import justlive.earth.breeze.frost.core.config.JobProperties;

/**
 * redis配置
 * 
 * @author wubo
 *
 */
@Configuration
public class RedisConfig {

  /**
   * 单机模式
   * 
   * @param redssionProperties
   * @return
   */
  @Bean
  @ConditionalOnProperty(name = "redisson.mode", havingValue = "0")
  RedissonClient redissonSingle(RedissonProperties redssionProperties) {
    Config config = new Config();
    SingleServerConfig serverConfig = config.useSingleServer()
        .setAddress(redssionProperties.getAddress()).setTimeout(redssionProperties.getTimeout())
        .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
        .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());

    if (StringUtils.hasText(redssionProperties.getPassword())) {
      serverConfig.setPassword(redssionProperties.getPassword());
    }

    return Redisson.create(config);
  }

  /**
   * 集群模式
   * 
   * @param redssionProperties
   * @return
   */
  @Bean
  @ConditionalOnProperty(name = "redisson.mode", havingValue = "1")
  RedissonClient redissonCluster(RedissonProperties redssionProperties) {
    Config config = new Config();
    ClusterServersConfig serverConfig =
        config.useClusterServers().addNodeAddress(redssionProperties.getSentinelAddresses())
            .setTimeout(redssionProperties.getTimeout())
            .setSlaveConnectionPoolSize(redssionProperties.getSlaveConnectionPoolSize())
            .setMasterConnectionPoolSize(redssionProperties.getMasterConnectionPoolSize());

    if (StringUtils.hasText(redssionProperties.getPassword())) {
      serverConfig.setPassword(redssionProperties.getPassword());
    }

    return Redisson.create(config);
  }

  /**
   * 执行线程池
   * 
   * @param props
   * @return
   */
  @Bean("redisson-executor")
  ExecutorService executorService(SystemProperties props) {

    return new ThreadPoolExecutor(props.getCorePoolSize(), props.getMaximumPoolSize(),
        props.getKeepAliveTime(), TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>(props.getQueueCapacity()),
        new BasicThreadFactory.Builder().namingPattern("redisson-executor-pool-%d").daemon(true)
            .build());
  }

  @Profile(JobProperties.PROFILE_CENTER)
  @Bean("thread-task-executor")
  ThreadPoolTaskExecutor threadPool(SystemProperties props) {
    ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
    threadPool.setQueueCapacity(props.getQueueCapacity());
    threadPool.setCorePoolSize(props.getCorePoolSize());
    threadPool.setMaxPoolSize(props.getMaximumPoolSize());
    threadPool.setKeepAliveSeconds(props.getKeepAliveTime());
    threadPool.setWaitForTasksToCompleteOnShutdown(true);
    threadPool.setAwaitTerminationSeconds(60);

    return threadPool;
  }
}
