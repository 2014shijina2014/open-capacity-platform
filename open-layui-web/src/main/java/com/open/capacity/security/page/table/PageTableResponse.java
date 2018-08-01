package com.open.capacity.security.page.table;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回
 *
 * @author 624191343@qq.com
 */
public class PageTableResponse implements Serializable {

    private static final long serialVersionUID = 620421858510718076L;

    //总数据数
    private Integer recordsTotal;
    private Integer recordsFiltered;
    //分数数据体
    private List<?> data;

    public PageTableResponse(Integer recordsTotal, Integer recordsFiltered, List<?> data) {
        super();
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    /**
     * 总数据数
     * @return
     */
    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * 总数据数
     * @param recordsTotal
     */
    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     *
     * @param recordsFiltered
     */
    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /**
     * 分数数据体
     * @return
     */
    public List<?> getData() {
        return data;
    }

    /**
     * 分数数据体
     * @param data 数据体
     */
    public void setData(List<?> data) {
        this.data = data;
    }

}