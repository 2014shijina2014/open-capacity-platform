package vip.justlive.frost.core.job;

import java.util.Objects;
import vip.justlive.common.base.exception.Exceptions;
import vip.justlive.frost.api.model.JobExecuteParam;
import vip.justlive.frost.api.model.JobInfo;
import vip.justlive.frost.core.util.ScriptJobFactory;

/**
 * script模式job包装
 * 
 * @author wubo
 *
 */
public class JobScriptExecuteWrapper extends AbstractJobExecuteWrapper {

  public JobScriptExecuteWrapper() {}

  public JobScriptExecuteWrapper(JobExecuteParam jobExecuteParam) {
    this.jobExecuteParam = jobExecuteParam;
  }

  @Override
  public void doRun() {
    this.before();
    if (!Objects.equals(jobInfo.getType(), JobInfo.TYPE.SCRIPT.name())) {
      throw Exceptions.fail("30002", "执行job类型不匹配");
    }
    IJob job = getIJob();
    job.execute(new DefaultJobContext(jobInfo));
  }

  @Override
  protected IJob getIJob() {
    return ScriptJobFactory.parse(jobInfo.getScript());
  }

}
