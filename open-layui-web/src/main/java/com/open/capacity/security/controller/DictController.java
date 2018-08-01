package com.open.capacity.security.controller;

import com.open.capacity.security.dao.DictDao;
import com.open.capacity.security.model.Dict;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典中心
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年3月20日 下午10:13:18 类说明
 */
@RestController
@RequestMapping("/dicts")
public class DictController {

    @Autowired
    private DictDao dictDao;

    /**
     * 新增字典
     *
     * @param dict 字典数据体
     * @return
     * @author caoheyang
     */
    @PreAuthorize("hasAuthority('dict:add')")
    @PostMapping
    @ApiOperation(value = "保存")
    public Dict save(@RequestBody Dict dict) {
        Dict d = dictDao.getByTypeAndK(dict.getType(), dict.getK());
        if (d != null) {
            throw new IllegalArgumentException("类型和key已存在");
        }
        dictDao.save(dict);
        return dict;
    }

    /**
     * 根据id获取字典值
     *
     * @param id 字典id
     * @return
     * @author caoheyang
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Dict get(@PathVariable Long id) {
        return dictDao.getById(id);
    }

    /**
     * 更新字典
     *
     * @param dict 字典数据体
     * @return
     * @author caoheyang
     */
    @PreAuthorize("hasAuthority('dict:add')")
    @PutMapping
    @ApiOperation(value = "更新字典")
    public Dict update(@RequestBody Dict dict) {
        dictDao.update(dict);
        return dict;
    }

    /**
     * 分页查询字段数据
     *
     * @param request 分页请求头
     * @return
     * @author caoheyang
     */
    @PreAuthorize("hasAuthority('dict:query')")
    @GetMapping(params = {"start", "length"})
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {
            @Override
            public int count(PageTableRequest request) {
                return dictDao.count(request.getParams());
            }
        }, new ListHandler() {
            @Override
            public List<Dict> list(PageTableRequest request) {
                return dictDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    /**
     * 删除字典
     *
     * @param id 字典id
     * @author caoheyang
     */
    @PreAuthorize("hasAuthority('dict:del')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        dictDao.delete(id);
    }

    /**
     * 根据type 查询字典
     *
     * @param type 字段类型 eg sex
     * @return
     * @author caoheyang
     */
    @GetMapping(params = "type")
    public List<Dict> listByType(String type) {
        return dictDao.listByType(type);
    }
}