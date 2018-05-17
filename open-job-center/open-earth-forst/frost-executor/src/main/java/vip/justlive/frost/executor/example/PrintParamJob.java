package vip.justlive.frost.executor.example;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.frost.core.job.IJob;
import vip.justlive.frost.core.job.Job;
import vip.justlive.frost.core.job.JobContext;

/**
 * 打印执行参数job例子
 * 
 * @author wubo
 *
 */
@Slf4j
@Job(value = "printParamJob", desc = "打印执行参数job例子")
@Component
public class PrintParamJob implements IJob {

  @Override
  public void execute(JobContext ctx) {
    log.info("执行参数: {}", ctx.getParam());
  }
}
