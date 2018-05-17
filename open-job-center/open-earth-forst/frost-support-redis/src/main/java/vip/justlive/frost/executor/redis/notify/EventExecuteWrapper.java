package vip.justlive.frost.executor.redis.notify;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vip.justlive.frost.core.job.AbstractWrapper;
import vip.justlive.frost.core.notify.Event;
import vip.justlive.frost.core.notify.EventListener;
import vip.justlive.frost.core.util.SpringBeansHolder;

/**
 * 事件执行包装
 * 
 * @author wubo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class EventExecuteWrapper extends AbstractWrapper {

  private Event event;

  @Override
  public void doRun() {
    EventListener listener = SpringBeansHolder.getBean(EventListener.class);
    listener.onEvent(event);
  }
}
