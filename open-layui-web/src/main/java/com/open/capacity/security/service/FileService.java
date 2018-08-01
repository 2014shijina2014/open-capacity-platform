package com.open.capacity.security.service;

import com.open.capacity.security.dao.FileInfoDao;
import com.open.capacity.security.model.FileInfo;
import com.open.capacity.security.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传业务
 * @author caoheyang
 * @version 20180730
 */
@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    @Value("${files.path}")
    private String filesPath;
    @Autowired
    private FileInfoDao fileInfoDao;

    /**
     * 文件保存 TODO 根据公司选择文件服务器
     * @param file
     * @return
     * @throws IOException
     */
    public FileInfo save(MultipartFile file) throws IOException {
        String fileOrigName = file.getOriginalFilename();
        if (!fileOrigName.contains(".")) {
            throw new IllegalArgumentException("缺少后缀名");
        }

        String md5 = FileUtil.fileMd5(file.getInputStream());
        FileInfo fileInfo = fileInfoDao.getById(md5);

        fileOrigName = fileOrigName.substring(fileOrigName.lastIndexOf("."));
        String pathname = FileUtil.getPath() + md5 + fileOrigName;
        String fullPath = filesPath + pathname;
        FileUtil.saveFile(file, fullPath);

        if (fileInfo != null) {
            fileInfo.setPath(fullPath);
            fileInfo.setUrl(pathname);
            fileInfoDao.update(fileInfo);
            return fileInfo;
        }

        long size = file.getSize();
        String contentType = file.getContentType();

        fileInfo = new FileInfo();
        fileInfo.setId(md5);
        fileInfo.setContentType(contentType);
        fileInfo.setSize(size);
        fileInfo.setPath(fullPath);
        fileInfo.setUrl(pathname);
        fileInfo.setType(contentType.startsWith("image/") ? 1 : 0);

        //存库
        fileInfoDao.save(fileInfo);

        log.debug("上传文件{}", fullPath);

        return fileInfo;

    }

    /**
     * 删除文件
     * @param id
     */
    public void delete(String id) {
        FileInfo fileInfo = fileInfoDao.getById(id);
       //判断文件是否存在
        if (fileInfo != null) {
            String fullPath = fileInfo.getPath();
            FileUtil.deleteFile(fullPath);

            fileInfoDao.delete(id);
            log.debug("删除文件：{}", fileInfo.getPath());
        }
    }
}
