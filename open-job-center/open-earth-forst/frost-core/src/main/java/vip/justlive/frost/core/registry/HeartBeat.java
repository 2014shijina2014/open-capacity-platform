package vip.justlive.frost.core.registry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 心跳
 * 
 * @author wubo
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeartBeat {

  public enum TYPE {
    /**
     * ping
     */
    PING,
    /**
     * 注册
     */
    REGISTER,
    /**
     * 注销
     */
    UNREGISTER
  }

  /**
   * 地址
   */
  private String address;

  /**
   * 类型
   */
  private String type;

  /**
   * 描述
   */
  private String description;

  @Override
  public String toString() {
    return String.format("[%s] | [%s] -> [%s] ", address, description, type);
  }
}
