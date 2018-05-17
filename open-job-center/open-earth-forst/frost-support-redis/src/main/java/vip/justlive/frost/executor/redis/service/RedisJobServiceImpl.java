package vip.justlive.frost.executor.redis.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.redisson.api.RedissonClient;
import org.redisson.executor.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import vip.justlive.common.base.exception.Exceptions;
import vip.justlive.frost.api.model.JobExecuteRecord;
import vip.justlive.frost.api.model.JobExecutor;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.api.model.JobScript;
import vip.justlive.frost.api.model.JobStatictis;
import vip.justlive.frost.api.model.Page;
import vip.justlive.frost.core.config.JobProperties;
import vip.justlive.frost.core.job.JobLogger;
import vip.justlive.frost.core.job.JobSchedule;
import vip.justlive.frost.core.persistence.JobRepository;
import vip.justlive.frost.core.service.JobService;

/**
 * redis调度服务实现类
 * 
 * @author wubo
 *
 */
@Service
public class RedisJobServiceImpl implements JobService {

  @Autowired
  JobRepository jobRepository;

  @Autowired(required = false)
  JobSchedule jobSchedule;

  @Autowired
  JobLogger jobLogger;

  @Autowired
  RedissonClient redissonClient;

  @Override
  public int countExecutors() {
    return jobRepository.countExecutors();
  }

  @Override
  public List<JobExecutor> queryExecutors() {
    return jobRepository.queryJobExecutors();
  }

  @Override
  public String addJob(JobInfo jobInfo) {

    if (!CronExpression.isValidExpression(jobInfo.getCron())) {
      throw Exceptions.fail("300001", "定时表达式格式有误");
    }
    if (jobInfo.isAuto()) {
      jobInfo.setStatus(JobInfo.STATUS.NORMAL.name());
    } else {
      jobInfo.setStatus(JobInfo.STATUS.PAUSED.name());
    }
    jobRepository.addJob(jobInfo);
    if (jobInfo.isAuto()) {
      jobSchedule.addJob(jobInfo.getId(), jobInfo.getCron());
    }

    return jobInfo.getId();
  }

  @Override
  public void updateJob(JobInfo jobInfo) {

    if (!CronExpression.isValidExpression(jobInfo.getCron())) {
      throw Exceptions.fail("300001", "定时表达式格式有误");
    }

    JobInfo localJobInfo = jobRepository.findJobInfoById(jobInfo.getId());
    if (localJobInfo == null) {
      throw Exceptions.fail("300002", "未查询到Job记录");
    }

    if (jobInfo.getChildJobIds() != null
        && Arrays.asList(jobInfo.getChildJobIds()).contains(jobInfo.getId())) {
      throw Exceptions.fail("300003", "子任务不能包含本任务");
    }

    localJobInfo.setCron(jobInfo.getCron());
    localJobInfo.setName(jobInfo.getName());
    localJobInfo.setGroup(jobInfo.getGroup());
    localJobInfo.setParam(jobInfo.getParam());
    localJobInfo.setType(jobInfo.getType());
    localJobInfo.setScript(jobInfo.getScript());
    localJobInfo.setFailStrategy(jobInfo.getFailStrategy());
    localJobInfo.setNotifyMails(jobInfo.getNotifyMails());
    localJobInfo.setChildJobIds(jobInfo.getChildJobIds());

    jobRepository.updateJob(localJobInfo);

    if (JobInfo.STATUS.NORMAL.name().equals(localJobInfo.getStatus())) {
      jobSchedule.refreshJob(jobInfo.getId(), jobInfo.getCron());
    }
  }

  @Override
  public void pauseJob(String jobId) {

    JobInfo localJobInfo = jobRepository.findJobInfoById(jobId);
    if (localJobInfo == null) {
      throw Exceptions.fail("300002", "未查询到Job记录");
    }

    localJobInfo.setStatus(JobInfo.STATUS.PAUSED.name());
    localJobInfo.setScript(null);
    jobSchedule.pauseJob(jobId);
    jobRepository.updateJob(localJobInfo);
  }

  @Override
  public void resumeJob(String jobId) {
    jobSchedule.resumeJob(jobId);
    JobInfo jobInfo = jobRepository.findJobInfoById(jobId);
    jobInfo.setStatus(JobInfo.STATUS.NORMAL.name());
    jobInfo.setScript(null);
    jobRepository.updateJob(jobInfo);
  }

  @Override
  public void removeJob(String jobId) {
    jobSchedule.removeJob(jobId);
    jobRepository.removeJobRecords(jobId);
    jobRepository.removeJobScripts(jobId);
    jobRepository.removeJob(jobId);
    jobLogger.removeLogger(jobId);
  }

  @Override
  public void triggerJob(String jobId) {
    jobSchedule.triggerJob(jobId);
  }

  @Override
  public int countJobInfos() {
    return jobRepository.countJobInfos();
  }

  @Override
  public Page<JobInfo> queryJobInfos(int pageIndex, int pageSize) {
    Page<JobInfo> page = new Page<>();
    page.setPageIndex(pageIndex);
    page.setPageSize(pageSize);

    int totalCount = this.countJobInfos();
    page.setTotalCount(totalCount);

    if (totalCount == 0) {
      return page;
    }
    // 倒序
    int from = Math.max(totalCount - page.getTo(), 0);
    int to = totalCount - page.getFrom();

    List<JobInfo> list = jobRepository.queryJobInfos(from, to);
    Collections.reverse(list);
    page.setItems(list);

    return page;
  }

  @Override
  public List<JobInfo> queryAllJobs() {
    return jobRepository.queryAllJobs();
  }

  @Override
  public JobInfo findJobInfoById(String id) {
    return jobRepository.findJobInfoById(id);
  }

  @Override
  public String addJobRecord(JobExecuteRecord record) {
    return jobRepository.addJobRecord(record);
  }

  @Override
  public Page<JobExecuteRecord> queryJobRecords(String groupKey, String jobKey, String jobId,
      int pageIndex, int pageSize) {
    Page<JobExecuteRecord> page = new Page<>();
    page.setPageIndex(pageIndex);
    page.setPageSize(pageSize);

    int totalCount = jobRepository.countJobRecords(groupKey, jobKey, jobId);
    page.setTotalCount(totalCount);

    if (totalCount == 0) {
      return page;
    }
    // 倒序
    int from = Math.max(totalCount - page.getTo(), 0);
    int to = totalCount - page.getFrom();
    List<JobExecuteRecord> list = jobRepository.queryJobRecords(groupKey, jobKey, jobId, from, to);
    Collections.reverse(list);
    page.setItems(list);
    return page;
  }

  @Override
  public void addJobScript(JobScript script) {
    jobRepository.addJobScript(script);
  }

  @Override
  public List<JobScript> queryJobScripts(String jobId) {
    return jobRepository.queryJobScripts(jobId);
  }

  @Override
  public JobStatictis queryJobStatictis(String begin, String end) {
    JobStatictis statictis = new JobStatictis();
    statictis.setTotalJobs((long) this.countJobInfos());
    statictis.setTotalExecutors((long) this.countExecutors());
    statictis.setTotalDispatches(redissonClient.getAtomicLong(String.join(JobProperties.SEPERATOR,
        JobProperties.CENTER_PREFIX, JobProperties.CENTER_STATISTICS,
        JobProperties.CENTER_STATISTICS_DISPATCH, JobProperties.CENTER_STATISTICS_RUNNING)).get());
    statictis.setTotalRunningExecutions(redissonClient
        .getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
            JobProperties.CENTER_STATISTICS, JobProperties.CENTER_STATISTICS_EXECUTE,
            JobProperties.CENTER_STATISTICS_RUNNING))
        .get());

    List<String> statictisDays = queryStatictisDays(begin, end);
    statictis.setStatictisDays(statictisDays);

    statictis.setFailDispatches(Lists.newArrayList());
    statictis.setSuccessDispatches(Lists.newArrayList());
    statictis.setFailExecutions(Lists.newArrayList());
    statictis.setSuccessExecutions(Lists.newArrayList());
    for (String day : statictisDays) {
      statictis.getSuccessDispatches()
          .add(redissonClient
              .getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
                  JobProperties.CENTER_STATISTICS, JobProperties.CENTER_STATISTICS_DISPATCH,
                  JobProperties.CENTER_STATISTICS_SUCCESS, day))
              .get());
      statictis.getFailDispatches()
          .add(redissonClient.getAtomicLong(String.join(JobProperties.SEPERATOR,
              JobProperties.CENTER_PREFIX, JobProperties.CENTER_STATISTICS,
              JobProperties.CENTER_STATISTICS_DISPATCH, JobProperties.CENTER_STATISTICS_FAIL, day))
              .get());
      statictis.getSuccessExecutions()
          .add(redissonClient
              .getAtomicLong(String.join(JobProperties.SEPERATOR, JobProperties.CENTER_PREFIX,
                  JobProperties.CENTER_STATISTICS, JobProperties.CENTER_STATISTICS_EXECUTE,
                  JobProperties.CENTER_STATISTICS_SUCCESS, day))
              .get());
      statictis.getFailExecutions()
          .add(redissonClient.getAtomicLong(String.join(JobProperties.SEPERATOR,
              JobProperties.CENTER_PREFIX, JobProperties.CENTER_STATISTICS,
              JobProperties.CENTER_STATISTICS_EXECUTE, JobProperties.CENTER_STATISTICS_FAIL, day))
              .get());
    }

    return statictis;
  }

  private List<String> queryStatictisDays(String begin, String end) {
    List<String> statictisDays = Lists.newArrayList();

    LocalDate from = LocalDate.parse(begin);
    LocalDate to = LocalDate.parse(end);

    while (from.isBefore(to) || from.equals(to)) {
      statictisDays.add(DateTimeFormatter.ISO_LOCAL_DATE.format(from));
      from = from.plusDays(1);
    }

    return statictisDays;
  }

}
