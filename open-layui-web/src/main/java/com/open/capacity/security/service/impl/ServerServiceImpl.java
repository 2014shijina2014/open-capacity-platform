package com.open.capacity.security.service.impl;

import com.open.capacity.security.dao.ServerDao;
import com.open.capacity.security.model.SysServer;
import com.open.capacity.security.service.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 服务管理
 **/
@Service
public class ServerServiceImpl implements ServerService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private ServerDao serverDao;

	@Override
	public void save(SysServer sysServer) {
		serverDao.save(sysServer);

		log.debug("新增服务{}", sysServer.getName());
	}

	@Override
	public void update(SysServer sysServer) {
		serverDao.update(sysServer);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		serverDao.delete(id);
		log.debug("删除服务id:{}", id);
	}

}
