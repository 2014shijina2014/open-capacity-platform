package vip.justlive.frost.core.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.common.base.exception.Exceptions;
import vip.justlive.frost.api.model.JobExecutor;
import vip.justlive.frost.api.model.JobGroup;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.job.IJob;
import vip.justlive.frost.core.job.Job;
import vip.justlive.frost.core.util.IpUtils;

/**
 * 注册抽象类
 * 
 * @author wubo
 *
 */
@Slf4j
public abstract class AbstractRegistry implements Registry {

  @Autowired
  protected JobProperties jobProps;

  @Autowired
  protected List<IJob> jobs;

  protected JobExecutor jobExecutorBean;

  @PostConstruct
  protected void init() {
    jobExecutorBean = this.jobExecutor();
  }

  /**
   * 当前执行器
   * 
   * @return
   */
  protected JobExecutor jobExecutor() {
    JobExecutor jobExecutor = new JobExecutor();
    jobExecutor.setId(UUID.randomUUID().toString());
    jobExecutor.setName(jobProps.getExecutor().getName());
    jobExecutor.setKey(jobProps.getExecutor().getKey());

    String address = jobProps.getExecutor().getIp();
    if (!StringUtils.hasText(address)) {
      address = IpUtils.ip();
    }
    address += IpUtils.SEPERATOR + jobProps.getExecutor().getPort();
    jobExecutor.setAddress(address);
    jobExecutor.setGroups(this.jobGroups(jobProps.getExecutor().getKey()));
    return jobExecutor;
  }

  /**
   * job分组
   * 
   * @return
   */
  protected List<JobGroup> jobGroups(String groupKey) {
    List<JobGroup> list = new ArrayList<>();
    Set<String> existNames = new HashSet<>();
    for (IJob job : jobs) {
      if (job.getClass().isAnnotationPresent(Job.class)) {
        Job jobAnnotation = job.getClass().getAnnotation(Job.class);
        if (existNames.add(jobAnnotation.value())) {
          JobGroup jobGroup = new JobGroup();
          // id
          jobGroup.setId(jobAnnotation.value());
          jobGroup.setJobKey(jobAnnotation.value());
          jobGroup.setJobDesc(jobAnnotation.desc());
          jobGroup.setGroupKey(groupKey);
          list.add(jobGroup);
        } else {
          throw Exceptions.fail("30000", "job [%s] 已存在", jobAnnotation.value());
        }
      } else {
        log.warn("[{}] missing @Job", job.getClass());
      }
    }
    return list;
  }
}
