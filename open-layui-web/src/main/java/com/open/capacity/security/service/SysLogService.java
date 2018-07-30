package com.open.capacity.security.service;

import com.open.capacity.security.dao.SysLogsDao;
import com.open.capacity.security.model.SysLogs;
import com.open.capacity.security.model.SysUser;
import com.open.capacity.security.utils.UserUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 系统日志
 * @author caoheyang
 * @version 20180730
 */
@Service
public class SysLogService {

    private static final Logger log = LoggerFactory.getLogger(SysLogService.class);

    @Autowired
    private SysLogsDao sysLogsDao;

    /**
     * 新增日志
     * @param sysLogs
     */
    public void save(SysLogs sysLogs) {
        SysUser user = UserUtil.getLoginUser();
        if (user == null || user.getId() == null) {
            return;
        }
        sysLogs.setUser(user);
        sysLogsDao.save(sysLogs);
    }

    /**
     * 保存日志
     * @param userId 用户id
     * @param module 模块编号
     * @param flag 成功失败
     * @param remark 备注
     */
    @Async
    public void save(Long userId, String module, Boolean flag, String remark) {
        SysLogs sysLogs = new SysLogs();
        sysLogs.setFlag(flag);
        sysLogs.setModule(module);
        sysLogs.setRemark(remark);

        SysUser user = new SysUser();
        user.setId(userId);
        sysLogs.setUser(user);

        sysLogsDao.save(sysLogs);

    }


    /**
     * 删除日志
     */
    public void deleteLogs() {
        Date date = DateUtils.addMonths(new Date(), -3);
        String time = DateFormatUtils.format(date, DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern());

        int n = sysLogsDao.deleteLogs(time);
        log.info("删除{}之前日志{}条", time, n);
    }
}
