package justlive.earth.breeze.frost.executor.example;

import org.springframework.stereotype.Component;
import justlive.earth.breeze.frost.core.job.IJob;
import justlive.earth.breeze.frost.core.job.Job;
import justlive.earth.breeze.frost.core.job.JobContext;
import lombok.extern.slf4j.Slf4j;

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
