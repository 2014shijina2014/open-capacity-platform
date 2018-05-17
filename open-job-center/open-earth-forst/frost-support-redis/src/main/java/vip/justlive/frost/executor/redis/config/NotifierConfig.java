package vip.justlive.frost.executor.redis.config;

import java.util.Map;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.notify.ChildrenJobEventNotifier;
import vip.justlive.frost.core.notify.CompositeNotifier;
import vip.justlive.frost.core.notify.EventListener;
import vip.justlive.frost.core.notify.EventPublisher;
import vip.justlive.frost.core.notify.MailEventNotifier;
import vip.justlive.frost.core.notify.Notifier;
import vip.justlive.frost.core.notify.RetryEventNotifier;
import vip.justlive.frost.executor.redis.notify.RedisEventPublisherImpl;

/**
 * 通知配置
 * 
 * @author wubo
 *
 */
@Configuration
public class NotifierConfig {

  @Bean
  EventPublisher publisher() {

    return new RedisEventPublisherImpl();
  }


  @Bean
  @Profile(JobProperties.PROFILE_CENTER)
  @ConditionalOnProperty(value = "frost.notifier.mail.enabled", havingValue = "true",
      matchIfMissing = true)
  @ConfigurationProperties("frost.notifier.mail")
  MailEventNotifier mailEventNotifier(MailSender sender) {
    return new MailEventNotifier(sender);
  }

  @Bean
  @Profile(JobProperties.PROFILE_CENTER)
  RetryEventNotifier retryEventNotifier() {
    return new RetryEventNotifier();
  }

  @Bean
  @Profile(JobProperties.PROFILE_CENTER)
  ChildrenJobEventNotifier childrenJobEventNotifier() {
    return new ChildrenJobEventNotifier();
  }

  @Bean
  @Profile(JobProperties.PROFILE_CENTER)
  @ConditionalOnBean(Notifier.class)
  CompositeNotifier compositeNotifier(Map<String, Notifier> notifiers) {
    return new CompositeNotifier(notifiers.values());
  }

  @Bean
  @Profile(JobProperties.PROFILE_CENTER)
  @ConditionalOnBean(CompositeNotifier.class)
  EventListener listener(CompositeNotifier notifier, SystemProperties props,
      RedissonClient redissonClient) {
    RScheduledExecutorService executor =
        redissonClient.getExecutorService(String.join(JobProperties.SEPERATOR,
            JobProperties.CENTER_PREFIX, EventPublisher.class.getName()));
    executor.registerWorkers(props.getWorkers());

    return new EventListener(notifier);
  }
}
