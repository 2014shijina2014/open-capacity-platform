package vip.justlive.frost.core.job;

/**
 * job定时处理接口
 * 
 * @author wubo
 *
 */
public interface JobSchedule {

  /**
   * 增加job
   * 
   * @param jobId
   * @param cron
   * @return
   */
  String addJob(String jobId, String cron);

  /**
   * 刷新job
   * 
   * @param jobId
   * @param cron
   * @return
   */
  String refreshJob(String jobId, String cron);

  /**
   * 暂停job
   * 
   * @param jobId
   */
  void pauseJob(String jobId);

  /**
   * 恢复job
   * 
   * @param jobId
   * @return
   */
  String resumeJob(String jobId);

  /**
   * 删除job
   * 
   * @param jobId
   */
  void removeJob(String jobId);

  /**
   * 触发 job
   * 
   * @param jobId
   */
  void triggerJob(String jobId);

  /**
   * 失败重试 job
   * 
   * @param jobId
   * @param loggerId
   * @param parentLoggerId
   */
  void retryJob(String jobId, String loggerId, String parentLoggerId);

  /**
   * 触发子job
   * 
   * @param jobId
   * @param loggerId
   */
  void triggerChildJob(String jobId, String loggerId);
}
