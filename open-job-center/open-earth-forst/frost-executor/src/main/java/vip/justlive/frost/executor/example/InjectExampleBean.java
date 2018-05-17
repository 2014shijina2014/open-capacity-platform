package vip.justlive.frost.executor.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.frost.core.config.JobProperties;

/**
 * 自动注入示例
 * 
 * @author wubo
 *
 */
@Slf4j
@Component
public class InjectExampleBean {

  @Autowired
  JobProperties props;

  public void say() {
    log.info("自动注入示例，打印job配置属性：{}", props);
  }
}
