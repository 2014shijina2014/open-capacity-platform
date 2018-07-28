package com.open.capacity.security.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.MicroServiceDao;
import com.open.capacity.security.dto.LoginUser;
import com.open.capacity.security.model.MicroService;
import com.open.capacity.security.model.SysPermission;
import com.open.capacity.security.service.MicroServiceService;
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
@Api(tags = "服务")
@RestController
@RequestMapping("/services")
public class MicroServiceController {

    @Autowired
    private MicroServiceDao microServiceDao;
    @Autowired
    private MicroServiceService microServiceService;

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

    private void setChild(List<SysPermission> permissions) {
        permissions.parallelStream().forEach(per -> {
            List<SysPermission> child = permissions.stream().filter(p -> p.getParentId().equals(per.getId()))
                    .collect(Collectors.toList());
            per.setChild(child);
        });
    }

    /**
     * 菜单列表
     *
     * @param pId
     * @param all
     * @param list
     */
    private void setPermissionsList(Long pId, List<MicroService> all, List<MicroService> list) {
        for (MicroService per : all) {
            if (per.getParentId().equals(pId)) {
                list.add(per);
                if (all.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    setPermissionsList(per.getId(), all, list);
                }
            }
        }
    }

    @GetMapping
    @ApiOperation(value = "服务列表")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<MicroService> permissionsList() {
        List<MicroService> microServices = microServiceDao.listAll();
        List<MicroService> list = Lists.newArrayList();
        setPermissionsList(0L, microServices, list);
        return list;
    }

    @GetMapping("/all")
    @ApiOperation(value = "所有服务")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public JSONArray permissionsAll() {
        List<MicroService> all = microServiceDao.listAll();
        JSONArray array = new JSONArray();
        setPermissionsTree(0L, all, array);
        return array;
    }

    @GetMapping("/parents")
    @ApiOperation(value = "一级服务")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public List<MicroService> parentMenu() {
        List<MicroService> parents = microServiceDao.listParents();
        return parents;
    }

    /**
     * 菜单树
     *
     * @param pId
     * @param all
     * @param array
     */
    private void setPermissionsTree(Long pId, List<MicroService> all, JSONArray array) {
        for (MicroService per : all) {
            if (per.getParentId().equals(pId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);
                if (all.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(per.getId(), all, child);
                }
            }
        }
    }

    @GetMapping(params = "clientId")
    @ApiOperation(value = "根据应用id查询权限")
    @PreAuthorize("hasAnyAuthority('sys:menu:query','sys:role:query')")
    public List<MicroService> listByRoleId(Long clientId) {
        return microServiceDao.listByClientId(clientId);
    }

    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存服务")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void save(@RequestBody MicroService microService) {
        microServiceDao.save(microService);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据服务id获取服务")
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public MicroService get(@PathVariable Long id) {
        return microServiceDao.getById(id);
    }

    @LogAnnotation
    @PutMapping
    @ApiOperation(value = "修改服务")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public void update(@RequestBody MicroService microService) {
        microServiceService.update(microService);
    }

    /**
     * 校验权限
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

    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除服务")
    @PreAuthorize("hasAuthority('sys:menu:del')")
    public void delete(@PathVariable Long id) {
        microServiceService.delete(id);
    }
}
