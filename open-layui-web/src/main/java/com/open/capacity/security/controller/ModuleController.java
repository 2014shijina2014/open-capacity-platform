package com.open.capacity.security.controller;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.SysModuleDao;
import com.open.capacity.security.model.SysModule;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.SysModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 模块管理
 **/
@Api(tags = "用户")
@RestController
@RequestMapping("/sys/module")
public class ModuleController {

    @Autowired
    SysModuleService sysModuleService;

    @Autowired
    SysModuleDao sysModuleDao;

    @GetMapping("/list")
    @ApiOperation(value = "模块列表")
    @PreAuthorize("hasAuthority('sys:module:query')")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new PageTableHandler.CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sysModuleDao.count(request.getParams());
            }
        }, new PageTableHandler.ListHandler() {

            @Override
            public List<SysModule> list(PageTableRequest request) {
                List<SysModule> list = sysModuleDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return list;
            }
        }).handle(request);
    }

    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存模块")
    @PreAuthorize("hasAuthority('sys:module:add')")
    public void save(@RequestBody SysModule sysModule) {
        sysModuleDao.insert(sysModule);
    }

    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除模块")
    @PreAuthorize("hasAuthority('sys:module:del')")
    public void delete(@PathVariable Long id) {
        sysModuleDao.deleteById(id);
    }

    @LogAnnotation
    @PutMapping
    @ApiOperation(value = "保存模块")
    @PreAuthorize("hasAuthority('sys:module:add')")
    public void update(@RequestBody SysModule sysModule) {
        sysModuleDao.update(sysModule);
    }

    @ApiOperation(value = "根据模块id获取模块")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:module:query')")
    public SysModule get(@PathVariable Long id) {
        return sysModuleDao.getById(id);
    }
}
