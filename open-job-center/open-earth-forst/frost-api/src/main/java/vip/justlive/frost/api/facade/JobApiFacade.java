package vip.justlive.frost.api.facade;

import vip.justlive.frost.api.model.JobInfo;

/**
 * job api facade
 * 
 * @author wubo
 *
 */
public interface JobApiFacade {

  /**
   * 添加Job
   * 
   * @param jobInfo
   * @return
   */
  String addJob(JobInfo jobInfo);

  /**
   * 修改job
   * 
   * @param jobInfo
   */
  void updateJob(JobInfo jobInfo);

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
   */
  void resumeJob(String jobId);

  /**
   * 删除job
   * 
   * @param jobId
   */
  void removeJob(String jobId);

  /**
   * 触发job
   * 
   * @param jobId
   */
  void triggerJob(String jobId);
}
