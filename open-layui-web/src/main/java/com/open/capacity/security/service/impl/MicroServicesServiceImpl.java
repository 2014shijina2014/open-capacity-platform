package com.open.capacity.security.service.impl;

import com.open.capacity.security.dao.ServiceDao;
import com.open.capacity.security.model.Permission;
import com.open.capacity.security.service.MicroServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MicroServicesServiceImpl implements MicroServiceService {

    private static final Logger log = LoggerFactory.getLogger(MicroServicesServiceImpl.class);

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public void save(Permission permission) {
        serviceDao.save(permission);

        log.debug("新增服务{}", permission.getName());
    }

    @Override
    public void update(Permission permission) {
        serviceDao.update(permission);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        serviceDao.delete(id);
        serviceDao.deleteByParentId(id);

        log.debug("删除菜单id:{}", id);
    }

}
