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
import com.open.capacity.security.service.OauthClientService;
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
@Api(tags = "应用相关接口")
@RestController
@RequestMapping("/clients")
public class OauthClientDetailsController {

    @Autowired
    private OauthClientService oauthClientService;
    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    /**
     * 新增应用
     *
     * @param clientDto 新增数据体
     */
    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "新增应用")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public void saveRole(@RequestBody OauthClientDetailsDto clientDto) {
        oauthClientService.saveClient(clientDto);
    }

    /**
     * 应用列表
     *
     * @param request 分页查询
     * @return
     */
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

    /**
     * 根据id获取应用
     *
     * @param id 应用id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取应用")
    @PreAuthorize("hasAuthority('sys:role:query')")
    public OauthClientDetails get(@PathVariable Long id) {
        return oauthClientDetailsDao.getById(id);
    }

    /**
     * 获取所有应用
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取所有应用")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<OauthClientDetails> roles() {
        return oauthClientDetailsDao.list(Maps.newHashMap(), null, null);
    }

    /**
     * 根据用户id获取该用户拥有的角色
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping(params = "userId")
    @ApiOperation(value = "根据用户id获取该用户拥有的角色")
    @PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
    public List<OauthClientDetails> roles(Long userId) {
        return oauthClientDetailsDao.listByUserId(userId);
    }

    /**
     * 删除应用
     *
     * @param id 应用id
     */
    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除应用")
    @PreAuthorize("hasAuthority('sys:role:del')")
    public void delete(@PathVariable Long id) {
        oauthClientService.deleteClient(id);
    }
}
