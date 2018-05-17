package vip.justlive.frost.core.job;

/**
 * job
 * 
 * @author wubo
 *
 */
public interface IJob {

  /**
   * 初始化
   */
  default void init() {}

  /**
   * 销毁
   */
  default void destroy() {}

  /**
   * 执行
   * 
   * @param ctx
   */
  void execute(JobContext ctx);

  /**
   * 异常处理，默认返回true。<br>
   * 返回true时使用全局异常处理逻辑<br>
   * 当需要对部分job特殊处理异常时，在实现类重写该方法并返回false
   * 
   * @return
   */
  default boolean exception() {
    return true;
  }
}
