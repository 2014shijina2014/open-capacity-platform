package com.open.capacity.security.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Base实体类
 *
 * @param <ID>
 */
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2054813493011812469L;

    private ID id;
    private Date createTime = new Date();
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
