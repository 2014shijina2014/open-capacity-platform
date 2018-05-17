package vip.justlive.frost.core.job;

/**
 * job日志
 * 
 * @author wubo
 *
 */
public interface JobLogger {

  /**
   * 绑定job日志
   * 
   * @param jobId
   * @return
   */
  String bindLog(String jobId);

  /**
   * 删除job对应日志
   * 
   * @param jobId
   */
  void removeLogger(String jobId);

  /**
   * 开始调度或执行任务
   * 
   * @param loggerId
   * @param type
   */
  void enter(String loggerId, String type);

  /**
   * 调度或执行任务结束
   * 
   * @param loggerId
   * @param type
   * @param success
   */
  void leave(String loggerId, String type, boolean success);
}
