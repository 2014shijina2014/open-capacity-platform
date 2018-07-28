package com.open.capacity.security.controller;

import com.google.common.collect.Maps;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.OauthClientDetailsDao;
import com.open.capacity.security.dto.OauthClientDetailsDto;
import com.open.capacity.security.model.OauthClientDetails;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应用相关接口
 *
 * @author owen 624191343@qq.com
 */
@Api(tags = "应用")
@RestController
@RequestMapping("/clients")
public class OauthClientDetailsController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "新增应用")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public void saveRole(@RequestBody OauthClientDetailsDto clientDto) {
        clientService.saveClient(clientDto);
    }

    @GetMapping
    @ApiOperation(value = "应用列表")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public PageTableResponse listRoles(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return oauthClientDetailsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<OauthClientDetails> list(PageTableRequest request) {
                List<OauthClientDetails> list = oauthClientDetailsDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return list;
            }
        }).handle(request);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public OauthClientDetails get(@PathVariable Long id) {
        return oauthClientDetailsDao.getById(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有应用")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<OauthClientDetails> roles() {
        return oauthClientDetailsDao.list(Maps.newHashMap(), null, null);
    }

    @GetMapping(params = "userId")
    @ApiOperation(value = "根据用户id获取该用户拥有的角色")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<OauthClientDetails> roles(Long userId) {
        return oauthClientDetailsDao.listByUserId(userId);
    }

    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('sys:role:del')")
    public void delete(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
