package com.open.capacity.security.model;

/**
 * 角色表
 *
 * @DBTable sys_role
 */
public class Role extends BaseEntity<Long> {

    private static final long serialVersionUID = -3802292814767103648L;

    //角色名称
    private String name;
    //描述
    private String description;

    /**
     * 角色名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
