package justlive.earth.breeze.frost.executor.example;

import java.util.Random;
import org.springframework.stereotype.Component;
import justlive.earth.breeze.frost.core.job.IJob;
import justlive.earth.breeze.frost.core.job.Job;
import justlive.earth.breeze.frost.core.job.JobContext;
import lombok.extern.slf4j.Slf4j;

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
