package com.open.capacity.security.dto;

import com.open.capacity.security.model.OauthClientDetails;

import java.util.List;

public class OauthClientDetailsDto extends OauthClientDetails {

    private static final long serialVersionUID = 1475637288060027265L;

    private List<Long> permissionIds;

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
