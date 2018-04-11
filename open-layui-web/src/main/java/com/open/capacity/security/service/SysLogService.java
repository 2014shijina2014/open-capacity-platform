package com.open.capacity.security.service;

import com.open.capacity.security.model.SysLogs;

/**
 * 日志service
 * 
 * @author 624191343@qq.com
 *
 *         2017年8月19日
 */
public interface SysLogService {

	void save(SysLogs sysLogs);

	void save(Long userId, String module, Boolean flag, String remark);

	void deleteLogs();
}
