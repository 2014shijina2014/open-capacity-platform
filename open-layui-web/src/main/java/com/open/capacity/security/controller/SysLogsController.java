package com.open.capacity.security.controller;

import com.open.capacity.security.dao.SysLogsDao;
import com.open.capacity.security.model.SysLogs;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 中台日志相关接口
 */
@Api(tags = "中台日志相关接口")
@RestController
@RequestMapping("/logs")
public class SysLogsController {

    @Autowired
    private SysLogsDao sysLogsDao;

    /**
     * 日志列表
     *
     * @param request 分页数据
     * @return
     */
    @GetMapping
    @PreAuthorize("hasAuthority('sys:log:query')")
    @ApiOperation(value = "日志列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {
            @Override
            public int count(PageTableRequest request) {
                return sysLogsDao.count(request.getParams());
            }
        }, new ListHandler() {
            @Override
            public List<SysLogs> list(PageTableRequest request) {
                return sysLogsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }
}
