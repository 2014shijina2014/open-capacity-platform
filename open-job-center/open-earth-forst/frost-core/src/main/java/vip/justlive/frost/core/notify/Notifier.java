package vip.justlive.frost.core.notify;

/**
 * 通知接口
 * 
 * @author wubo
 *
 */
public interface Notifier {

  /**
   * 通知
   * 
   * @param event
   */
  void notify(Event event);
}
