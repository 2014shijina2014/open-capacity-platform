package com.open.capacity.security.service;

import com.open.capacity.security.dto.SysRoleDto;

public interface RoleService {

    void saveRole(SysRoleDto roleDto);

    void deleteRole(Long id);
}
