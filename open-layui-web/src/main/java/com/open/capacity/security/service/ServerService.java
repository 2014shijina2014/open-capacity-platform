package com.open.capacity.security.service;

import com.open.capacity.security.model.SysServer;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 服务管理
 **/
public interface ServerService {

	void save(SysServer sysServer);

	void update(SysServer sysServer);

	void delete(Long id);
}
