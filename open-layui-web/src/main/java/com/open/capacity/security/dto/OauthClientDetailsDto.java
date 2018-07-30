package com.open.capacity.security.dto;

import com.open.capacity.security.model.OauthClientDetails;

import java.util.List;

/**
 * OAUTH2客户端模式表业务实体
 */
public class OauthClientDetailsDto extends OauthClientDetails {

    private static final long serialVersionUID = 1475637288060027265L;

    //应用可访问的api的接口id
    private List<Long> permissionIds;

    /**
     * 应用可访问的api的接口id
     * @return
     */
    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    /**
     * 应用可访问的api的接口id
     * @param permissionIds api的接口id
     */
    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
