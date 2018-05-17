package justlive.earth.breeze.frost.executor.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import justlive.earth.breeze.frost.core.registry.Registry;

/**
 * 执行器配置
 * 
 * @author wubo
 *
 */
@Configuration
public class ExecutorConfig {

  @Autowired
  Registry registry;

  @PostConstruct
  void init() {
    registry.register();
  }

}
