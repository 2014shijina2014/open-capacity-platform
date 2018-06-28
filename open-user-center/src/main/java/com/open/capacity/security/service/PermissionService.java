package com.open.capacity.security.service;

import com.open.capacity.security.model.Permission;

public interface PermissionService {

	void save(Permission permission);

	void update(Permission permission);

	void delete(Long id);
}
