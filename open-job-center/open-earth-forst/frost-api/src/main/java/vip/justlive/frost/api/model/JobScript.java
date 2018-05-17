package vip.justlive.frost.api.model;

import java.util.Date;
import lombok.Data;

/**
 * 任务脚本
 * 
 * @author wubo
 *
 */
@Data
public class JobScript {

  /**
   * id
   */
  private String id;

  /**
   * 用户job
   */
  private String jobId;

  /**
   * 版本
   */
  private String version;

  /**
   * 脚本
   */
  private String script;

  /**
   * 时间
   */
  private Date time;

}
