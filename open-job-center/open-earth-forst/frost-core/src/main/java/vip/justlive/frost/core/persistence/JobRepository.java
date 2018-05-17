package vip.justlive.frost.core.persistence;

import java.util.List;
import vip.justlive.frost.api.model.JobExecuteRecord;
import vip.justlive.frost.api.model.JobExecutor;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.api.model.JobRecordStatus;
import vip.justlive.frost.api.model.JobScript;

/**
 * job持久化
 * 
 * @author wubo
 *
 */
public interface JobRepository {

  /**
   * 统计执行器个数
   * 
   * @return
   */
  int countExecutors();

  /**
   * 获取执行器列表
   * 
   * @return
   */
  List<JobExecutor> queryJobExecutors();

  /**
   * 添加job
   * 
   * @param jobInfo
   */
  void addJob(JobInfo jobInfo);

  /**
   * 修改job
   * 
   * @param jobInfo
   */
  void updateJob(JobInfo jobInfo);

  /**
   * 删除job
   * 
   * @param jobId
   */
  void removeJob(String jobId);

  /**
   * 统计job个数
   * 
   * @return
   */
  int countJobInfos();

  /**
   * 获取job列表
   * 
   * @param from
   * @param to
   * @return
   */
  List<JobInfo> queryJobInfos(int from, int to);

  /**
   * 获取所有任务
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
   * 获取job执行记录总数
   * 
   * @param groupKey
   * @param jobKey
   * @param jobId
   * @return
   */
  int countJobRecords(String groupKey, String jobKey, String jobId);

  /**
   * 获取job执行记录列表
   * 
   * @param groupKey
   * @param jobKey
   * @param jobId
   * @param from
   * @param to
   * @return
   */
  List<JobExecuteRecord> queryJobRecords(String groupKey, String jobKey, String jobId, int from,
      int to);

  /**
   * 根据id获取job执行记录
   * 
   * @param id
   * @return
   */
  JobExecuteRecord findJobExecuteRecordById(String id);

  /**
   * 增加任务执行状态
   * 
   * @param recordStatus
   */
  void addJobRecordStatus(JobRecordStatus recordStatus);

  /**
   * 删除job执行记录
   * 
   * @param jobId
   */
  void removeJobRecords(String jobId);

  /**
   * 增加任务脚本
   * 
   * @param script
   */
  void addJobScript(JobScript script);

  /**
   * 查询任务脚本
   * 
   * @param jobId
   * @return
   */
  List<JobScript> queryJobScripts(String jobId);

  /**
   * 删除任务脚本
   * 
   * @param jobId
   */
  void removeJobScripts(String jobId);
}
