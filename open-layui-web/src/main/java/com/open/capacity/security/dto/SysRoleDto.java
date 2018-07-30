package com.open.capacity.security.dto;

import com.open.capacity.security.model.SysRole;

import java.util.List;

/**
 * 系统角色业务实体类
 */
public class SysRoleDto extends SysRole {

    private static final long serialVersionUID = 4218495592167610193L;

    //角色对应的资源ID
    private List<Long> permissionIds;

    /**
     * 角色对应的资源ID
     * @return
     */
    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    /**
     * 角色对应的资源ID
     * @param permissionIds
     */
    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
