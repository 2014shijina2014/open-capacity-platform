package com.open.capacity.security.service;

import com.open.capacity.security.dto.RoleDto;

public interface RoleService {

	void saveRole(RoleDto roleDto);

	void deleteRole(Long id);
}
