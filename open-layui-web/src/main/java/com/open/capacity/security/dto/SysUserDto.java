package com.open.capacity.security.dto;

import com.open.capacity.security.model.SysUser;

import java.util.List;

/**
 * 后台用户业务实体类
 */
public class SysUserDto extends SysUser {

    private static final long serialVersionUID = -184009306207076712L;

    //用户角色id
    private List<Long> roleIds;

    /**
     * 用户角色id
     * @return
     */
    public List<Long> getRoleIds() {
        return roleIds;
    }

    /**
     * 用户角色id
     * @param roleIds
     */
    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

}
