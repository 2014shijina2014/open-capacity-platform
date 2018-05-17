package justlive.earth.breeze.frost.client;

import org.junit.Assert;
import org.junit.Before;
import justlive.earth.breeze.frost.api.facade.JobApiFacade;
import justlive.earth.breeze.frost.api.model.JobGroup;
import justlive.earth.breeze.frost.api.model.JobInfo;

/**
 * 测试
 * 
 * @author wubo
 *
 */
public class FacadeProxyTest {

  JobApiFacade jobApiFacade;

  @Before
  public void before() {
    FacadeProxy proxy = FacadeProxy.newProxy("classpath:frost.properties");
    jobApiFacade = proxy.getJobApiFacade();
  }

  @org.junit.Test
  public void test() {

  }

  public void testJob() {

    JobInfo jobInfo = new JobInfo();
    jobInfo.setName("测试添加");
    jobInfo.setType(JobInfo.TYPE.BEAN.name());
    JobGroup group = new JobGroup();
    group.setGroupKey("executor-demo");
    group.setJobKey("printTimeJob");
    jobInfo.setGroup(group);
    jobInfo.setCron("0 * * * * ?");
    jobInfo.setFailStrategy(JobInfo.STRATEGY.NOTIFY.name());
    String id = jobApiFacade.addJob(jobInfo);

    Assert.assertNotNull(id);

    jobApiFacade.triggerJob(id);
    jobApiFacade.resumeJob(id);
    jobApiFacade.pauseJob(id);
    jobInfo.setCron("1 * * * * ?");
    jobInfo.setId(id);
    jobApiFacade.updateJob(jobInfo);
    jobApiFacade.removeJob(id);

  }



}
