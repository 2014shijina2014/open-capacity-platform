package com.open.capacity.security.controller;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.FileInfoDao;
import com.open.capacity.security.dto.LayuiFile;
import com.open.capacity.security.dto.LayuiFile.LayuiFileData;
import com.open.capacity.security.model.FileInfo;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * 文件维护相关接口
 *
 * @author caoheyang
 * @version 20180728
 */
@Api(tags = "文件相关接口")
@RestController
@RequestMapping("/files")
public class FileInfoController {

    @Autowired
    private FileService fileService;
    @Autowired
    private FileInfoDao fileInfoDao;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return
     * @author caoheyang
     * @version 20180728
     */
    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "文件上传")
    public FileInfo uploadFile(MultipartFile file) throws IOException {
        return fileService.save(file);
    }

    /**
     * layui富文本文件自定义上传
     *
     * @param file
     * @param domain
     * @return
     * @throws IOException
     * @author caoheyang
     * @version 20180728
     */
    @LogAnnotation
    @PostMapping("/layui")
    @ApiOperation(value = "layui富文本文件自定义上传")
    public LayuiFile uploadLayuiFile(MultipartFile file, String domain) throws IOException {
        FileInfo fileInfo = fileService.save(file);

        LayuiFile layuiFile = new LayuiFile();
        layuiFile.setCode(0);
        LayuiFileData data = new LayuiFileData();
        layuiFile.setData(data);
        data.setSrc(domain + "/statics" + fileInfo.getUrl());
        data.setTitle(file.getOriginalFilename());

        return layuiFile;
    }

    /**
     * 文件查询
     *
     * @param request 分页数据体
     * @return
     * @author caoheyang
     * @version 20180728
     */
    @GetMapping
    @ApiOperation(value = "文件查询")
    @PreAuthorize("hasAuthority('sys:file:query')")
    public PageTableResponse listFiles(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {
            @Override
            public int count(PageTableRequest request) {
                return fileInfoDao.count(request.getParams());
            }
        }, new ListHandler() {
            @Override
            public List<FileInfo> list(PageTableRequest request) {
                List<FileInfo> list = fileInfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return list;
            }
        }).handle(request);
    }

    /**
     * 文件删除
     *
     * @param id 文件id
     * @author caoheyang
     * @version 20180728
     */
    @LogAnnotation
    @DeleteMapping("/{id}")
    @ApiOperation(value = "文件删除")
    @PreAuthorize("hasAuthority('sys:file:del')")
    public void delete(@PathVariable String id) {
        fileService.delete(id);
    }

}
