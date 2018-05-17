package vip.justlive.frost.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * job执行参数
 * 
 * @author wubo
 *
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobExecuteParam {

  /**
   * job id
   */
  @NonNull
  private String jobId;

  /**
   * 处理逻辑id
   */
  private String handlerId;

  /**
   * 订阅key
   */
  private String topicKey;

  /**
   * 日志id
   */
  private String loggerId;

  /**
   * 是否是失败重试
   */
  private boolean failRetry;

  /**
   * 父任务日志id
   */
  private String parentLoggerId;

}
