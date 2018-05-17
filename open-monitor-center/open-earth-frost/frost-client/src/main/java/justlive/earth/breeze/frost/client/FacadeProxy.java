package justlive.earth.breeze.frost.client;

import justlive.earth.breeze.frost.api.facade.JobApiFacade;
import justlive.earth.breeze.snow.common.base.support.ConfigFactory;
import lombok.Getter;

/**
 * 代理类
 * 
 * @author wubo
 *
 */
@Getter
public class FacadeProxy {

  private JobApiFacade jobApiFacade;

  FacadeProxy(String location) {
    ConfigFactory.loadProperties(location);
    ClientProperties clientProps = ConfigFactory.load(ClientProperties.class);
    this.jobApiFacade = new JobApiFacadeImpl(clientProps);
  }

  /**
   * 创建代理
   * 
   * @param location 配置文件路径
   * @return
   */
  public static FacadeProxy newProxy(String location) {
    return new FacadeProxy(location);
  }

}
