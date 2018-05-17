package vip.justlive.frost.core.job;

import vip.justlive.frost.api.model.JobInfo;

/**
 * job上下文
 * 
 * @author wubo
 *
 */
public interface JobContext {

  /**
   * 获取job信息
   * 
   * @return
   */
  JobInfo getInfo();

  /**
   * 获取参数
   * 
   * @return
   */
  String getParam();

}
