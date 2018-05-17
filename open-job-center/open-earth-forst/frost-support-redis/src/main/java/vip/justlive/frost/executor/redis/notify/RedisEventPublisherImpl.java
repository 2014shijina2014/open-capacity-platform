package vip.justlive.frost.executor.redis.notify;

import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.notify.Event;
import vip.justlive.frost.core.notify.EventPublisher;

/**
 * redis实现的事件发布
 * 
 * @author wubo
 *
 */
public class RedisEventPublisherImpl implements EventPublisher {

  @Autowired
  RedissonClient redissonClient;

  @Override
  public void publish(Event event) {
    RScheduledExecutorService executor =
        redissonClient.getExecutorService(String.join(JobProperties.SEPERATOR,
            JobProperties.CENTER_PREFIX, EventPublisher.class.getName()));
    executor.execute(new EventExecuteWrapper(event));
  }

}
