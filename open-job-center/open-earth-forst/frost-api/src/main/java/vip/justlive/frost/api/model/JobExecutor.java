package vip.justlive.frost.api.model;

import java.util.List;
import lombok.Data;

/**
 * job执行器信息
 * 
 * @author wubo
 *
 */
@Data
public class JobExecutor {

  /**
   * 编号
   */
  private String id;

  /**
   * 执行器名称
   */
  private String name;

  /**
   * 执行器key，作为JobGroup的groupKey
   */
  private String key;

  /**
   * 执行器地址
   */
  private String address;

  /**
   * 执行器中可处理job列表
   */
  private List<JobGroup> groups;
}
