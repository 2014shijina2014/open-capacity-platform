package vip.justlive.frost.core.notify;

/**
 * 组合通知
 * 
 * @author wubo
 *
 */
public class CompositeNotifier extends AbstractEventNotifier {

  private final Iterable<Notifier> delegates;

  public CompositeNotifier(Iterable<Notifier> delegates) {
    this.delegates = delegates;
  }

  @Override
  protected void doNotify(Event event) {
    for (Notifier notifier : delegates) {
      notifier.notify(event);
    }
  }
}
