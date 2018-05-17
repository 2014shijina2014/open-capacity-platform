package vip.justlive.frost.core.notify;

import lombok.Data;

/**
 * 事件监听
 * 
 * @author wubo
 *
 */
@Data
public class EventListener {

  private final Notifier notifier;

  /**
   * 处理事件
   * 
   * @param event
   */
  public void onEvent(Event event) {
    notifier.notify(event);
  }
}
