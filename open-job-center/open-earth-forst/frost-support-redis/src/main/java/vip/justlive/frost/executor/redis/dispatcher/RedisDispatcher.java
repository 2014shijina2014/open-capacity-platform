package vip.justlive.frost.executor.redis.dispatcher;

import java.lang.reflect.Field;
import java.util.Objects;
import org.redisson.RedissonExecutorService;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import vip.justlive.common.base.exception.Exceptions;
import vip.justlive.frost.api.model.JobExecuteParam;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.dispacher.Dispatcher;
import vip.justlive.frost.core.job.JobBeanExecuteWrapper;
import vip.justlive.frost.core.job.JobScriptExecuteWrapper;
import vip.justlive.frost.core.persistence.JobRepository;

/**
 * redis分发实现类
 * 
 * @author wubo
 *
 */
@Profile(JobProperties.PROFILE_CENTER)
@Component
public class RedisDispatcher implements Dispatcher {

  @Autowired
  RedissonClient redissonClient;

  @Autowired
  JobRepository jobRepository;

  @Override
  public void dispatch(JobExecuteParam param) {

    JobInfo jobInfo = jobRepository.findJobInfoById(param.getJobId());
    if (jobInfo == null) {
      throw Exceptions.fail("30005", String.format("未查询到任务 %s", param));
    }
    this.checkDispatch(param);
    if (Objects.equals(JobInfo.TYPE.SCRIPT.name(), jobInfo.getType())) {
      redissonClient.getExecutorService(param.getTopicKey())
          .execute(new JobScriptExecuteWrapper(param));
    } else {
      redissonClient.getExecutorService(param.getTopicKey())
          .execute(new JobBeanExecuteWrapper(param));
    }
  }

  @Override
  public void checkDispatch(JobExecuteParam param) {

    // redisson 当没有worker时候，调用countActiveWorkers会阻塞
    // 由于计算count是基于订阅模式下的publish触发增加各自worker到workersCounterAtomicLong事件
    // 再去获取semaphore，最后返回workersCounterAtomicLong的数值
    // 但是没有worker的时候，publish返回0， 触发不了事件，导致semaphore阻塞
    // Semaphore阻塞的情况：Semaphore第一次getSemaphore且acquire(0)会阻塞
    // 这个问题已经提到redisson的issue上
    if (nonActiveWorkers(param.getTopicKey())) {
      throw Exceptions.fail("30000", "没有可调度的执行器");
    }
    int workers = redissonClient.getExecutorService(param.getTopicKey()).countActiveWorkers();
    if (workers == 0) {
      throw Exceptions.fail("30000", "没有可调度的执行器");
    }
  }

  /**
   * remove this method redisson fixed the bug <br>
   * 注意：这个方法没有清除用于计算的semaphore和counter
   */
  private boolean nonActiveWorkers(String key) {
    RScheduledExecutorService service = redissonClient.getExecutorService(key);
    Field field = ReflectionUtils.findField(RedissonExecutorService.class, "workersTopic");
    try {
      field.setAccessible(true);
      @SuppressWarnings("unchecked")
      RTopic<String> workTopic = (RTopic<String>) field.get(service);
      int count = (int) workTopic.publish("0");
      return count == 0;
    } catch (IllegalArgumentException | IllegalAccessException e) {
      // nothing
      return false;
    }
  }
}
