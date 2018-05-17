package vip.justlive.frost.core.service;

import java.util.List;
import vip.justlive.frost.api.model.JobExecuteRecord;
import vip.justlive.frost.api.model.JobExecutor;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.api.model.JobScript;
import vip.justlive.frost.api.model.JobStatictis;
import vip.justlive.frost.api.model.Page;

/**
 * 调度中心服务接口
 * 
 * @author wubo
 *
 */
public interface JobService {

  /**
   * 统计执行器个数
   * 
   * @return
   */
  int countExecutors();

  /**
   * 获取激活的执行器列表
   * 
   * @return
   */
  List<JobExecutor> queryExecutors();

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

  /**
   * 统计job个数
   * 
   * @return
   */
  int countJobInfos();

  /**
   * 获取job列表
   * 
   * @param pageIndex
   * @param pageSize
   * @return
   */
  Page<JobInfo> queryJobInfos(int pageIndex, int pageSize);

  /**
   * 获取所有job
   * 
   * @return
   */
  List<JobInfo> queryAllJobs();

  /**
   * 根据id获取job
   * 
   * @param id
   * @return
   */
  JobInfo findJobInfoById(String id);

  /**
   * 添加job执行记录
   * 
   * @param record
   * @return
   */
  String addJobRecord(JobExecuteRecord record);

  /**
   * 获取job执行记录列表
   * 
   * @param groupKey
   * @param jobKey
   * @param jobId
   * @param pageIndex
   * @param pageSize
   * @return
   */
  Page<JobExecuteRecord> queryJobRecords(String groupKey, String jobKey, String jobId,
      int pageIndex, int pageSize);

  /**
   * 增加任务脚本
   * 
   * @param script
   */
  void addJobScript(JobScript script);

  /**
   * 查询脚本列表
   * 
   * @param jobId
   * @return
   */
  List<JobScript> queryJobScripts(String jobId);

  /**
   * 获取统计
   * 
   * @param begin
   * @param end
   * @return
   */
  JobStatictis queryJobStatictis(String begin, String end);
}
