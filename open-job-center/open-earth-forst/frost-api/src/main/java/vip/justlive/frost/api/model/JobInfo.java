package vip.justlive.frost.api.model;

import lombok.Data;

/**
 * job信息
 * 
 * @author wubo
 *
 */
@Data
public class JobInfo {

  public enum STATUS {
    /**
     * 正常
     */
    NORMAL,
    /**
     * 暂停
     */
    PAUSED
  }

  public enum TYPE {
    /**
     * bean实例
     */
    BEAN,
    /**
     * 脚本
     */
    SCRIPT
  }

  public enum STRATEGY {
    /**
     * 通知
     */
    NOTIFY,
    /**
     * 重试
     */
    RETRY;
  }

  /**
   * 编号
   */
  private String id;

  /**
   * 名称
   */
  private String name;

  /**
   * 分组
   */
  private JobGroup group;

  /**
   * 定时表达式
   */
  private String cron;

  /**
   * 任务状态
   */
  private String status;

  /**
   * 任务类型
   */
  private String type;

  /**
   * 脚本
   */
  private String script;

  /**
   * 参数
   */
  private String param;

  /**
   * 是否自动执行
   */
  private boolean auto;

  /**
   * 失败策略
   */
  private String failStrategy;

  /**
   * 失败通知邮件地址（每个任务特别的通知人）
   */
  private String[] notifyMails;

  /**
   * 子任务id
   */
  private String[] childJobIds;

}
