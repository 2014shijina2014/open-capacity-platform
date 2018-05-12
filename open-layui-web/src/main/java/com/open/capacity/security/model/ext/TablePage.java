package com.open.capacity.security.model.ext;

import java.util.List;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 列表页面
 **/
public class TablePage {
    private int code;
    private String msg;
    private long total;
    private List<Object> rows;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }


}
