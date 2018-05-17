package justlive.earth.breeze.frost.executor.example;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import justlive.earth.breeze.frost.core.job.IJob;
import justlive.earth.breeze.frost.core.job.Job;
import justlive.earth.breeze.frost.core.job.JobContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 打印时间job，例子
 * 
 * @author wubo
 *
 */
@Slf4j
@Job(value = "printTimeJob", desc = "打印时间job例子")
@Component
public class PrintTimeJob implements IJob {

  @Override
  public void execute(JobContext ctx) {
    log.info("current time is {}", LocalDateTime.now());
  }

}
