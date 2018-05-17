package justlive.earth.breeze.frost.client;

import justlive.earth.breeze.snow.common.base.annotation.Value;
import lombok.Data;

/**
 * client配置
 * 
 * @author wubo
 *
 */
@Data
public class ClientProperties {

  /**
   * 调度中心地址
   */
  @Value("${frost.client.baseUrl}")
  private String baseUrl;

  /**
   * 用户名
   */
  @Value("${frost.client.username}")
  private String username;

  /**
   * 密码
   */
  @Value("${frost.client.password}")
  private String password;
}
