package justlive.earth.breeze.frost.core.job;

import justlive.earth.breeze.frost.api.model.JobInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
