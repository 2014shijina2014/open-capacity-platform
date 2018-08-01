package com.open.capacity.security.page.table;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页查询参数
 *
 * @author 624191343@qq.com
 */
public class PageTableRequest implements Serializable {

    private static final long serialVersionUID = 7328071045193618467L;

    //偏移量
    private Integer offset;
    //获取数量
    private Integer limit;
    //查询条件
    private Map<String, Object> params;

    /**
     * 偏移量
     * @return
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 偏移量
     * @param offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 获取数量
     * @return
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 获取数量
     * @param limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 查询条件
     * @return
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * 查询条件
     * @param params
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
