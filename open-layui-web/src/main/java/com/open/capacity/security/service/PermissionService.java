package com.open.capacity.security.service;

import com.open.capacity.security.model.SysPermission;

public interface PermissionService {

    void save(SysPermission permission);

    void update(SysPermission permission);

    void delete(Long id);
}
