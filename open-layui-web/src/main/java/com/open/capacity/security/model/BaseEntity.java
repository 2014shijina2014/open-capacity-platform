package com.open.capacity.security.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Base实体类
 *
 * @param <ID> 主键id
 * @author heyang
 */
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2054813493011812469L;
    //主键id
    private ID id;
    //添加时间
    private Date createTime = new Date();
    //更改时间
    private Date updateTime = new Date();

    /**
     * ID
     *
     * @return
     */
    public ID getId() {
        return id;
    }

    /**
     * ID
     *
     * @param id
     */
    public void setId(ID id) {
        this.id = id;
    }

    /**
     * 创建时间
     *
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建时间
     *
     * @return
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 创建时间
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
