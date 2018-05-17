package justlive.earth.breeze.frost.executor.redis.notify;

import justlive.earth.breeze.frost.core.job.AbstractWrapper;
import justlive.earth.breeze.frost.core.notify.Event;
import justlive.earth.breeze.frost.core.notify.EventListener;
import justlive.earth.breeze.frost.core.util.SpringBeansHolder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
