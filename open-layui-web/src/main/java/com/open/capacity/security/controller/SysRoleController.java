package com.open.capacity.security.controller;

import com.google.common.collect.Maps;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.SysRoleDao;
import com.open.capacity.security.dto.SysRoleDto;
import com.open.capacity.security.model.SysRole;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author owen 624191343@qq.com
 */
@Api(tags = "中台角色")
@RestController
@RequestMapping("/roles")
public class SysRoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private SysRoleDao sysRoleDao;

    /**
     * 保存角色
     *
     * @param roleDto 角色
     */
    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存角色")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public void saveRole(@RequestBody SysRoleDto roleDto) {
        roleService.saveRole(roleDto);
    }


    /**
     * 角色列表
     *
     * @param request 分页查询实体
     * @return
     */
    @GetMapping
    @ApiOperation(value = "角色列表")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public PageTableResponse listRoles(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sysRoleDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<SysRole> list(PageTableRequest request) {
                List<SysRole> list = sysRoleDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return list;
            }
        }).handle(request);
    }

    /**
     * 根据id获取角色
     *
     * @param id id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取角色")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public SysRole get(@PathVariable Long id) {
        return sysRoleDao.getById(id);
    }

    /**
     * 所有角色
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "所有角色")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<SysRole> roles() {
        return sysRoleDao.list(Maps.newHashMap(), null, null);
    }

    /**
     * 根据用户id获取拥有的角色
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping(params = "userId")
    @ApiOperation(value = "根据用户id获取拥有的角色")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<SysRole> roles(Long userId) {
        return sysRoleDao.listByUserId(userId);
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     */
    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除角色")
    @PreAuthorize("hasAuthority('sys:role:del')")
    public void delete(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
