package justlive.earth.breeze.frost.core.job;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import org.springframework.util.StringUtils;
import justlive.earth.breeze.frost.api.model.JobExecuteParam;
import justlive.earth.breeze.frost.api.model.JobExecuteRecord;
import justlive.earth.breeze.frost.api.model.JobInfo;
import justlive.earth.breeze.frost.api.model.JobRecordStatus;
import justlive.earth.breeze.frost.core.config.JobProperties;
import justlive.earth.breeze.frost.core.notify.Event;
import justlive.earth.breeze.frost.core.notify.EventPublisher;
import justlive.earth.breeze.frost.core.persistence.JobRepository;
import justlive.earth.breeze.frost.core.util.IpUtils;
import justlive.earth.breeze.frost.core.util.SpringBeansHolder;
import justlive.earth.breeze.snow.common.base.exception.CodedException;

/**
 * 执行job抽象
 * 
 * @author wubo
 *
 */
public abstract class AbstractJobExecuteWrapper extends AbstractWrapper {

  protected JobExecuteParam jobExecuteParam;

  protected JobInfo jobInfo;

  protected JobRecordStatus jobRecordStatus;

  protected void before() {
    Instant instant = ZonedDateTime.now().toInstant();
    // 触发开始执行任务事件
    EventPublisher publisher = SpringBeansHolder.getBean(EventPublisher.class);
    publisher.publish(
        new Event(jobExecuteParam, Event.TYPE.EXECUTE_ENTER.name(), null, instant.toEpochMilli()));
    JobLogger jobLogger = SpringBeansHolder.getBean(JobLogger.class);
    jobLogger.enter(jobExecuteParam.getLoggerId(), JobProperties.CENTER_STATISTICS_EXECUTE);
    JobRepository jobRepository = SpringBeansHolder.getBean(JobRepository.class);
    jobInfo = jobRepository.findJobInfoById(jobExecuteParam.getJobId());
    jobRecordStatus = new JobRecordStatus();
    jobRecordStatus.setId(UUID.randomUUID().toString());
    if (jobExecuteParam.isFailRetry()) {
      jobRecordStatus.setType(3);
    } else {
      jobRecordStatus.setType(1);
    }
    jobRecordStatus.setLoggerId(jobExecuteParam.getLoggerId());
    jobRecordStatus.setTime(Date.from(instant));
  }

  @Override
  public void success() {
    JobRepository jobRepository = SpringBeansHolder.getBean(JobRepository.class);
    jobRecordStatus.setStatus(JobExecuteRecord.STATUS.SUCCESS.name());
    jobRecordStatus.setMsg(String.format("执行成功 [%s]", address()));
    jobRepository.addJobRecordStatus(jobRecordStatus);
    // 触发任务执行成功事件
    EventPublisher publisher = SpringBeansHolder.getBean(EventPublisher.class);
    publisher.publish(new Event(jobExecuteParam, Event.TYPE.EXECUTE_SUCCESS.name(), null,
        ZonedDateTime.now().toInstant().toEpochMilli()));
    JobLogger jobLogger = SpringBeansHolder.getBean(JobLogger.class);
    jobLogger.leave(jobExecuteParam.getLoggerId(), JobProperties.CENTER_STATISTICS_EXECUTE, true);
  }

  @Override
  public void exception(Exception e) {
    super.exception(e);
    jobRecordStatus.setStatus(JobExecuteRecord.STATUS.FAIL.name());
    String cause;
    if (e instanceof CodedException) {
      cause = ((CodedException) e).getErrorCode().toString();
    } else {
      cause = e.getMessage();
    }
    jobRecordStatus.setMsg(String.format("执行失败 [%s] [%s]", address(), cause));
    JobRepository jobRepository = SpringBeansHolder.getBean(JobRepository.class);
    jobRepository.addJobRecordStatus(jobRecordStatus);

    IJob job = getIJob();
    if (job.exception()) {
      // 通知事件
      EventPublisher publisher = SpringBeansHolder.getBean(EventPublisher.class);
      publisher.publish(new Event(jobExecuteParam, Event.TYPE.EXECUTE_FAIL.name(),
          jobRecordStatus.getMsg(), jobRecordStatus.getTime().getTime()));
      if (!jobExecuteParam.isFailRetry()) {
        // 失败重试事件
        jobExecuteParam.setFailRetry(true);
        publisher.publish(new Event(jobExecuteParam, Event.TYPE.EXECUTE_FAIL_RETRY.name(),
            jobRecordStatus.getMsg(), jobRecordStatus.getTime().getTime()));
      }
    }
    JobLogger jobLogger = SpringBeansHolder.getBean(JobLogger.class);
    jobLogger.leave(jobExecuteParam.getLoggerId(), JobProperties.CENTER_STATISTICS_EXECUTE, false);
  }

  /**
   * 获取任务处理逻辑
   * 
   * @return
   */
  protected abstract IJob getIJob();

  private String address() {
    JobProperties props = SpringBeansHolder.getBean(JobProperties.class);
    String address = props.getExecutor().getIp();
    if (!StringUtils.hasText(address)) {
      address = IpUtils.ip();
    }
    address += IpUtils.SEPERATOR + props.getExecutor().getPort();
    return address;
  }
}
