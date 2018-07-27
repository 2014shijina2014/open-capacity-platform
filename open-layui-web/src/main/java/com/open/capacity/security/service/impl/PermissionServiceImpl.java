package com.open.capacity.security.service.impl;

import com.open.capacity.security.dao.SysPermissionDao;
import com.open.capacity.security.model.Permission;
import com.open.capacity.security.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PermissionServiceImpl implements PermissionService {

    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public void save(Permission permission) {
        sysPermissionDao.save(permission);

        log.debug("新增菜单{}", permission.getName());
    }

    @Override
    public void update(Permission permission) {
        sysPermissionDao.update(permission);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sysPermissionDao.deleteRolePermission(id);
        sysPermissionDao.delete(id);
        sysPermissionDao.deleteByParentId(id);

        log.debug("删除菜单id:{}", id);
    }

}
