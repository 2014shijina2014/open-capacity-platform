package vip.justlive.frost.core.job;

import vip.justlive.frost.api.model.JobExecuteParam;
import vip.justlive.frost.core.util.SpringBeansHolder;

/**
 * bean模式job包装
 * 
 * @author wubo
 *
 */
public class JobBeanExecuteWrapper extends AbstractJobExecuteWrapper {

  public JobBeanExecuteWrapper() {}

  public JobBeanExecuteWrapper(JobExecuteParam jobExecuteParam) {
    this.jobExecuteParam = jobExecuteParam;
  }

  @Override
  public void doRun() {
    this.before();
    IJob job = getIJob();
    job.execute(new DefaultJobContext(jobInfo));
  }

  @Override
  protected IJob getIJob() {
    return SpringBeansHolder.getBean(jobExecuteParam.getHandlerId(), IJob.class);
  }

}
