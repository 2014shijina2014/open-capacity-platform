package com.open.capacity.security.service;

import com.open.capacity.security.dao.SysRoleDao;
import com.open.capacity.security.dto.SysRoleDto;
import com.open.capacity.security.model.SysRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户角色的管理逻辑
 * @author caoheyang
 * @version 20180730
 */
@Service
public class RoleService {

    private static final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * 操作角色
     * @param roleDto 角色
     */
    @Transactional
    public void saveRole(SysRoleDto roleDto) {
        SysRole role = roleDto;
        List<Long> permissionIds = roleDto.getPermissionIds();
        permissionIds.remove(0L);

        if (role.getId() != null) {   // 修改
            updateRole(role, permissionIds);
        } else {     // 新增
            saveRole(role, permissionIds);
        }
    }

    /**
     * 新增
     * @param role 角色
     * @param permissionIds 功能点
     */
    private void saveRole(SysRole role, List<Long> permissionIds) {
        SysRole r = sysRoleDao.getRole(role.getName());
        if (r != null) {
            throw new IllegalArgumentException(role.getName() + "已存在");
        }

        sysRoleDao.save(role);
        if (!CollectionUtils.isEmpty(permissionIds)) {
            sysRoleDao.saveRolePermission(role.getId(), permissionIds);
        }
        log.debug("新增角色{}", role.getName());
    }

    /**
     * 更新
     * @param role 角色
     * @param permissionIds  功能点
     */
    private void updateRole(SysRole role, List<Long> permissionIds) {
        SysRole r = sysRoleDao.getRole(role.getName());
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


    /**
     * 删除角色
     * @param id 角色id
     */
    @Transactional
    public void deleteRole(Long id) {
        sysRoleDao.deleteRolePermission(id);
        sysRoleDao.deleteRoleUser(id);
        sysRoleDao.delete(id);

        log.debug("删除角色id:{}", id);
    }

}
