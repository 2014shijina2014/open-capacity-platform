package vip.justlive.frost.core.dispacher;

import vip.justlive.frost.api.model.JobExecuteParam;

/**
 * 分发接口
 * 
 * @author wubo
 *
 */
public interface Dispatcher {

  /**
   * 分发Job，失败会抛出运行时异常
   * 
   * @param param
   */
  void dispatch(JobExecuteParam param);

  /**
   * 校验是否抛出异常，失败会抛出运行时异常
   * 
   * @param param
   * @return
   */
  void checkDispatch(JobExecuteParam param);
}
