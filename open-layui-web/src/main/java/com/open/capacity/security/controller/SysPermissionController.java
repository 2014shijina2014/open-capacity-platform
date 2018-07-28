package com.open.capacity.security.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.SysPermissionDao;
import com.open.capacity.security.dto.LoginUser;
import com.open.capacity.security.model.SysPermission;
import com.open.capacity.security.service.SysPermissionService;
import com.open.capacity.security.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 权限相关接口
 *
 * @author owen 624191343@qq.com
 */
@Api(tags = "中台资源权限")
@RestController
@RequestMapping("/permissions")
public class SysPermissionController {

    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 当前登录用户拥有的权限
     *
     * @return
     */
    @ApiOperation(value = "当前登录用户拥有的权限")
    @GetMapping("/current")
    public List<SysPermission> permissionsCurrent() {
        LoginUser loginUser = UserUtil.getLoginUser();
        List<SysPermission> list = loginUser.getPermissions();
        final List<SysPermission> permissions = list.stream().filter(l -> l.getType().equals(1))
                .collect(Collectors.toList());
        setChild(permissions);
        return permissions.stream().filter(p -> p.getParentId().equals(0L)).collect(Collectors.toList());
    }

    /**
     * 菜单列表
     *
     * @param pId
     * @param permissionsAll
     * @param list
     */
    private void setPermissionsList(Long pId, List<SysPermission> permissionsAll, List<SysPermission> list) {
        for (SysPermission per : permissionsAll) {
            if (per.getParentId().equals(pId)) {
                list.add(per);
                if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    setPermissionsList(per.getId(), permissionsAll, list);
                }
            }
        }
    }

    /**
     * TODO 与 获取所有一级菜单 parentMenu的区别？
     *
     * @return
     */
    @GetMapping
    @ApiOperation(value = "菜单列表")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<SysPermission> permissionsList() {
        List<SysPermission> permissionsAll = sysPermissionDao.listAll();
        List<SysPermission> list = Lists.newArrayList();
        setPermissionsList(0L, permissionsAll, list);
        return list;
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取所有菜单")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public JSONArray permissionsAll() {
        List<SysPermission> permissionsAll = sysPermissionDao.listAll();
        JSONArray array = new JSONArray();
        setPermissionsTree(0L, permissionsAll, array);
        return array;
    }

    /**
     * 获取所有一级菜单
     *
     * @return
     */
    @GetMapping("/parents")
    @ApiOperation(value = "获取所有一级菜单")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<SysPermission> parentMenu() {
        List<SysPermission> parents = sysPermissionDao.listParents();
        return parents;
    }

    /**
     * 菜单树
     *
     * @param pId            父id
     * @param permissionsAll 所有中台资源
     * @param array          TODO?
     */
    private void setPermissionsTree(Long pId, List<SysPermission> permissionsAll, JSONArray array) {
        for (SysPermission per : permissionsAll) {
            if (per.getParentId().equals(pId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);

                if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(per.getId(), permissionsAll, child);
                }
            }
        }
    }

    /**
     * 根据角色id删除权限
     *
     * @param roleId 角色id
     * @return
     */
    @GetMapping(params = "roleId")
    @ApiOperation(value = "根据角色id删除权限")
    @PreAuthorize("hasAnyAuthority('sys:menu:query','sys:role:query')")
    public List<SysPermission> listByRoleId(Long roleId) {
        return sysPermissionDao.listByRoleId(roleId);
    }

    /**
     * 新增中台资源菜单
     *
     * @param permission 中台资源菜单
     */
    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存中台资源菜单")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void save(@RequestBody SysPermission permission) {
        sysPermissionDao.save(permission);
    }

    /**
     * 根据id获取中台资源菜单
     *
     * @param id 中台资源菜单id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取中台资源菜单")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public SysPermission get(@PathVariable Long id) {
        return sysPermissionDao.getById(id);
    }

    /**
     * 修改中台资源菜单
     *
     * @param permission
     */
    @LogAnnotation
    @PutMapping
    @ApiOperation(value = "修改中台资源菜单")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void update(@RequestBody SysPermission permission) {
        sysPermissionService.update(permission);
    }

    /**
     * 校验当前用户的权限
     *
     * @return
     */
    @GetMapping("/owns")
    @ApiOperation(value = "校验当前用户的权限")
    public Set<String> ownsPermission() {
        List<SysPermission> permissions = UserUtil.getLoginUser().getPermissions();
        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptySet();
        }

        return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(SysPermission::getPermission).collect(Collectors.toSet());
    }

    /**
     * 删除中台资源菜单
     *
     * @param id 中台资源菜单id
     */
    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除中台资源菜单")
    @PreAuthorize("hasAuthority('sys:menu:del')")
    public void delete(@PathVariable Long id) {
        sysPermissionService.delete(id);
    }

    /**
     * 设置一个菜单的子菜单
     *
     * @param permissions
     */
    private void setChild(List<SysPermission> permissions) {
        permissions.parallelStream().forEach(per -> {
            List<SysPermission> child = permissions.stream().filter(p -> p.getParentId().equals(per.getId()))
                    .collect(Collectors.toList());
            per.setChild(child);
        });
    }
}
