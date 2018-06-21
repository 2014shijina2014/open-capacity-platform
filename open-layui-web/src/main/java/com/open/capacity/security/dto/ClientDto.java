package com.open.capacity.security.dto;

import java.util.List;

import com.open.capacity.security.model.Client;

public class ClientDto extends Client {

	private static final long serialVersionUID = 1475637288060027265L;
	
	private List<Long> permissionIds;

	public List<Long> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(List<Long> permissionIds) {
		this.permissionIds = permissionIds;
	}
}
