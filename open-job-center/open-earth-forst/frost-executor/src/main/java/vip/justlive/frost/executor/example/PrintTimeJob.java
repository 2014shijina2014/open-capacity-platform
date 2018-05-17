package vip.justlive.frost.executor.example;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.frost.core.job.IJob;
import vip.justlive.frost.core.job.Job;
import vip.justlive.frost.core.job.JobContext;

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
