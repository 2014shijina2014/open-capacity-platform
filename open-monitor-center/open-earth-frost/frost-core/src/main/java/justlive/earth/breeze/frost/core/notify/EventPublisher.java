package justlive.earth.breeze.frost.core.notify;

/**
 * 事件发布接口
 * 
 * @author wubo
 *
 */
public interface EventPublisher {

  /**
   * 发布
   * 
   * @param event
   */
  void publish(Event event);
}
