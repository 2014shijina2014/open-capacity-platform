package vip.justlive.frost.executor.example;

import java.util.Random;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.frost.core.job.IJob;
import vip.justlive.frost.core.job.Job;
import vip.justlive.frost.core.job.JobContext;

/**
 * 统计job
 * 
 * @author wubo
 *
 */
@Slf4j
@Job(value = "staticJob", desc = "统计job")
@Component
public class StaticJob implements IJob {

  Random random = new Random();

  @Override
  public void execute(JobContext ctx) {
    log.info("there are {} jobs", random.nextInt(10));
  }

}
