package vip.justlive.frost.executor.redis.job;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RListMultimap;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.job.JobLogger;

/**
 * redis实现
 * 
 * @author wubo
 *
 */
@Component
public class RedisJobLoggerImpl implements JobLogger {

  @Autowired
  RedissonClient redissonClient;

  @Override
  public String bindLog(String jobId) {
    String id = UUID.randomUUID().toString();
    RMap<String, String> map = redissonClient.getMap(String.join(JobProperties.SEPERATOR,
        JobProperties.CENTER_PREFIX, JobLogger.class.getName()));
    RListMultimap<String, String> listmap = redissonClient
        .getListMultimap(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
            JobLogger.class.getName(), RListMultimap.class.getSimpleName()));
    map.put(id, jobId);
    listmap.put(jobId, id);
    return id;
  }

  @Override
  public void removeLogger(String jobId) {
    RMap<String, String> map = redissonClient.getMap(String.join(JobProperties.SEPERATOR,
        JobProperties.CENTER_PREFIX, JobLogger.class.getName()));
    RListMultimap<String, String> listmap = redissonClient
        .getListMultimap(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
            JobLogger.class.getName(), RListMultimap.class.getSimpleName()));
    List<String> list = listmap.removeAll(jobId);
    for (String id : list) {
      map.remove(id);
    }
  }

  @Override
  public void enter(String loggerId, String type) {
    // 运行中 ++
    RAtomicLong atomic = redissonClient
        .getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
            JobProperties.CENTER_STATISTICS, type, JobProperties.CENTER_STATISTICS_RUNNING));
    atomic.incrementAndGet();
  }

  @Override
  public void leave(String loggerId, String type, boolean success) {
    // 运行中 --
    if (Objects.equals(JobProperties.CENTER_STATISTICS_EXECUTE, type)) {
      redissonClient
          .getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
              JobProperties.CENTER_STATISTICS, type, JobProperties.CENTER_STATISTICS_RUNNING))
          .decrementAndGet();
    }

    String key;
    if (success) {
      key = JobProperties.CENTER_STATISTICS_SUCCESS;
    } else {
      key = JobProperties.CENTER_STATISTICS_FAIL;
    }
    redissonClient.getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
        JobProperties.CENTER_STATISTICS, type, key,
        DateTimeFormatter.ISO_LOCAL_DATE.format(ZonedDateTime.now()))).incrementAndGet();
  }
}
