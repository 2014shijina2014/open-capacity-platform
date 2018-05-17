package vip.justlive.frost.core.job;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vip.justlive.frost.api.model.JobInfo;

/**
 * 默认Job上下文
 * 
 * @author wubo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class DefaultJobContext implements JobContext {

  private JobInfo jobInfo;

  @Override
  public JobInfo getInfo() {
    return jobInfo;
  }

  @Override
  public String getParam() {
    return jobInfo.getParam();
  }
}
