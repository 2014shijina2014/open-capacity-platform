package vip.justlive.frost.api.model;

import java.util.List;
import lombok.Data;

/**
 * 分页
 * 
 * @author wubo
 *
 * @param <T>
 */
@Data
public class Page<T> {

  /**
   * 当前页
   */
  private Integer pageIndex;


  /**
   * 每页数量
   */
  private Integer pageSize;

  /**
   * 总数
   */
  private Integer totalCount;

  /**
   * 数据
   */
  private List<T> items;

  /**
   * from
   * 
   * @return
   */
  public Integer getFrom() {
    if (pageIndex != null && pageSize != null) {
      return (pageIndex - 1) * pageSize;
    }
    return null;
  }

  /**
   * to
   * 
   * @return
   */
  public Integer getTo() {
    if (pageIndex != null && pageSize != null) {
      return pageIndex * pageSize;
    }
    return null;
  }
}
