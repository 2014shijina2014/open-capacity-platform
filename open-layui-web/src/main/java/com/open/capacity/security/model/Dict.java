package com.open.capacity.security.model;

/**
 * 字典库
 *
 * @DBTable dict
 */
public class Dict extends BaseEntity<Long> {

    private static final long serialVersionUID = -2431140186410912787L;
    //字段类型 eg sex
    private String type;
    //key值
    private String k;
    //中文
    private String val;

    /**
     * 字段类型 eg sex
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 字段类型 eg sex
     *
     * @return
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * key值
     *
     * @return
     */
    public String getK() {
        return k;
    }

    /**
     * key值
     *
     * @return
     */
    public void setK(String k) {
        this.k = k;
    }

    /**
     * 中文 val
     *
     * @return
     */
    public String getVal() {
        return val;
    }

    /**
     * 中文val
     *
     * @param val
     */
    public void setVal(String val) {
        this.val = val;
    }

}
