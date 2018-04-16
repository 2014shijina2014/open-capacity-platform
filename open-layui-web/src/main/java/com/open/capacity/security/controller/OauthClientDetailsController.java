package com.open.capacity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.capacity.security.dao.OauthClientDetailsDao;
import com.open.capacity.security.model.OauthClientDetails;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/oauthClientDetailss")
public class OauthClientDetailsController {

    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public OauthClientDetails save(@RequestBody OauthClientDetails oauthClientDetails) {
        oauthClientDetailsDao.save(oauthClientDetails);

        return oauthClientDetails;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public OauthClientDetails get(@PathVariable Long id) {
        return oauthClientDetailsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public OauthClientDetails update(@RequestBody OauthClientDetails oauthClientDetails) {
        oauthClientDetailsDao.update(oauthClientDetails);

        return oauthClientDetails;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return oauthClientDetailsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<OauthClientDetails> list(PageTableRequest request) {
                return oauthClientDetailsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        oauthClientDetailsDao.delete(id);
    }
}
