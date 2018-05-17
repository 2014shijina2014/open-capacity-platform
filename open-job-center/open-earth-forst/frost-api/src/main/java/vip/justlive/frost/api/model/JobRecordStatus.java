package vip.justlive.frost.api.model;

import java.util.Date;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 状态记录
 * 
 * @author wubo
 *
 */
@Data
@NoArgsConstructor
public class JobRecordStatus {

  private String id;

  private String loggerId;

  private Integer type;

  private String status;

  private String msg;

  private Date time;

  public void fill(JobExecuteRecord record) {
    if (Objects.equals(loggerId, record.getId())) {
      if (type % 2 == 0) {
        record.setDispachMsg(msg);
        record.setDispachStatus(status);
        record.setDispachTime(time);
      } else {
        record.setExecuteMsg(msg);
        record.setExecuteStatus(status);
        record.setExecuteTime(time);
      }
    }
  }
}
