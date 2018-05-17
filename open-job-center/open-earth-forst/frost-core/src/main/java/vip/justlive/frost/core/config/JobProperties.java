package vip.justlive.frost.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/**
 * 执行器配置属性
 * 
 * @author wubo
 */
@Data
@ConfigurationProperties(prefix = "frost.job")
@Configuration
public class JobProperties {

  public static final String PROFILE_CENTER = "center";

  public static final String PROFILE_EXECUTOR = "executor";

  public static final String SEPERATOR = "|";

  public static final String CENTER_PREFIX = "frost-center";

  public static final String EXECUTOR_PREFIX = "frost-executor";

  public static final String JOB_GROUP_PREFIX = "frost-job-group";

  public static final String JOB_SCRIPT_PREFIX = "frost-job-script";

  public static final String CENTER_STATISTICS = "center_statistics";

  public static final String CENTER_STATISTICS_DISPATCH = "dispatch";

  public static final String CENTER_STATISTICS_EXECUTE = "execute";

  public static final String CENTER_STATISTICS_RUNNING = "running";

  public static final String CENTER_STATISTICS_SUCCESS = "success";

  public static final String CENTER_STATISTICS_FAIL = "fail";

  public static final Integer HEARTBEAT = 5;

  /**
   * 每个job支持并行处理数
   */
  private Integer parallel = 1;

  /**
   * 执行器
   */
  private Executor executor;

  @Data
  public static class Executor {

    /**
     * 执行器名称
     */
    private String name;

    /**
     * 执行器Key
     */
    private String key;

    /**
     * 执行器部署ip
     */
    private String ip;

    /**
     * 执行器监听端口
     */
    private Integer port;

    /**
     * 是否开启脚本任务执行
     */
    private Boolean scriptJobEnabled = true;
  }

}
