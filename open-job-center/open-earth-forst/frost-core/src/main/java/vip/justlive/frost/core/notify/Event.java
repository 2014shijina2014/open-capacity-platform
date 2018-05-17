package vip.justlive.frost.core.notify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vip.justlive.frost.api.model.JobExecuteParam;

/**
 * 事件类
 * 
 * @author wubo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

  public enum TYPE {
    /**
     * 调度失败
     */
    DISPATCH_FAIL,
    /**
     * 执行失败
     */
    EXECUTE_FAIL,
    /**
     * 调度失败重试
     */
    DISPATCH_FAIL_RETRY,
    /**
     * 执行失败重试
     */
    EXECUTE_FAIL_RETRY,
    /**
     * 开始执行
     */
    EXECUTE_ENTER,
    /**
     * 执行成功
     */
    EXECUTE_SUCCESS;
  }

  /**
   * data
   */
  private JobExecuteParam data;

  /**
   * 类型
   */
  private String type;

  /**
   * 消息
   */
  private String message;

  /**
   * 时间戳
   */
  private long timestamp;


}
