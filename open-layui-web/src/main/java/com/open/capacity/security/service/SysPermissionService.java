package com.open.capacity.security.service;

import com.open.capacity.security.dao.SysPermissionDao;
import com.open.capacity.security.model.SysPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPermissionService {

    private static final Logger log = LoggerFactory.getLogger(SysPermissionService.class);

    @Autowired
    private SysPermissionDao sysPermissionDao;


    public void save(SysPermission permission) {
        sysPermissionDao.save(permission);

        log.debug("新增菜单{}", permission.getName());
    }


    public void update(SysPermission permission) {
        sysPermissionDao.update(permission);
    }


    @Transactional
    public void delete(Long id) {
        sysPermissionDao.deleteRolePermission(id);
        sysPermissionDao.delete(id);
        sysPermissionDao.deleteByParentId(id);

        log.debug("删除菜单id:{}", id);
    }

}
