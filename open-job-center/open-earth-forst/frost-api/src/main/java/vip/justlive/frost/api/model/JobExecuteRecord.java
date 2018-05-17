package vip.justlive.frost.api.model;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * job执行记录
 * 
 * @author wubo
 *
 */
@Data
public class JobExecuteRecord {

  public enum STATUS {
    /**
     * 成功
     */
    SUCCESS,
    /**
     * 失败
     */
    FAIL;
  }

  /**
   * 编号
   */
  private String id;

  /**
   * 任务编号
   */
  private String jobId;

  /**
   * 分发时间
   */
  private Date dispachTime;

  /**
   * 分发状态
   */
  private String dispachStatus;

  /**
   * 分发备注
   */
  private String dispachMsg;

  /**
   * 执行时间
   * 
   */
  private Date executeTime;

  /**
   * 执行状态
   */
  private String executeStatus;

  /**
   * 执行备注
   */
  private String executeMsg;

  /**
   * 执行状态列表
   */
  private List<JobRecordStatus> recordStatuses;

}
