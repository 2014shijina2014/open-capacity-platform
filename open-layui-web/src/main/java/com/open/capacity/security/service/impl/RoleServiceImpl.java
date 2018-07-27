package com.open.capacity.security.service.impl;

import com.open.capacity.security.dao.SysRoleDao;
import com.open.capacity.security.dto.RoleDto;
import com.open.capacity.security.model.Role;
import com.open.capacity.security.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    @Transactional
    public void saveRole(RoleDto roleDto) {
        Role role = roleDto;
        List<Long> permissionIds = roleDto.getPermissionIds();
        permissionIds.remove(0L);

        if (role.getId() != null) {// 修改
            updateRole(role, permissionIds);
        } else {// 新增
            saveRole(role, permissionIds);
        }
    }

    private void saveRole(Role role, List<Long> permissionIds) {
        Role r = sysRoleDao.getRole(role.getName());
        if (r != null) {
            throw new IllegalArgumentException(role.getName() + "已存在");
        }

        sysRoleDao.save(role);
        if (!CollectionUtils.isEmpty(permissionIds)) {
            sysRoleDao.saveRolePermission(role.getId(), permissionIds);
        }
        log.debug("新增角色{}", role.getName());
    }

    private void updateRole(Role role, List<Long> permissionIds) {
        Role r = sysRoleDao.getRole(role.getName());
        if (r != null && r.getId() != role.getId()) {
            throw new IllegalArgumentException(role.getName() + "已存在");
        }

        sysRoleDao.update(role);

        sysRoleDao.deleteRolePermission(role.getId());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            sysRoleDao.saveRolePermission(role.getId(), permissionIds);
        }
        log.debug("修改角色{}", role.getName());
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        sysRoleDao.deleteRolePermission(id);
        sysRoleDao.deleteRoleUser(id);
        sysRoleDao.delete(id);

        log.debug("删除角色id:{}", id);
    }

}
