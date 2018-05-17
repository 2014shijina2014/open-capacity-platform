package vip.justlive.frost.api.model;

import java.util.List;
import lombok.Data;

/**
 * job 统计
 * 
 * @author wubo
 *
 */
@Data
public class JobStatictis {

  /**
   * 任务总数
   */
  private Long totalJobs;

  /**
   * 在线执行器总数
   */
  private Long totalExecutors;

  /**
   * 调度总次数
   */
  private Long totalDispatches;

  /**
   * 运行中的执行
   */
  private Long totalRunningExecutions;

  /**
   * 统计日期
   */
  private List<String> statictisDays;


  /**
   * 成功的调度
   */
  private List<Long> successDispatches;

  /**
   * 失败的调度
   */
  private List<Long> failDispatches;

  /**
   * 成功的执行
   */
  private List<Long> successExecutions;

  /**
   * 失败的执行
   */
  private List<Long> failExecutions;

}
