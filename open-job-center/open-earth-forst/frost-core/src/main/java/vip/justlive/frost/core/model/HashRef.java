package vip.justlive.frost.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Hash引用
 * 
 * @author wubo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HashRef {

  /**
   * key
   */
  private String key;

  /**
   * 下标
   */
  private int index;
}
