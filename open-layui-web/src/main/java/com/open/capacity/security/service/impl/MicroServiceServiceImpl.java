package com.open.capacity.security.service.impl;

import com.open.capacity.security.dao.MicroServiceDao;
import com.open.capacity.security.model.MicroService;
import com.open.capacity.security.service.MicroServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MicroServiceServiceImpl implements MicroServiceService {

    private static final Logger log = LoggerFactory.getLogger(MicroServiceServiceImpl.class);

    @Autowired
    private MicroServiceDao microServiceDao;

    @Override
    public void save(MicroService microService) {
        microServiceDao.save(microService);

        log.debug("新增服务{}", microService.getName());
    }

    @Override
    public void update(MicroService microService) {
        microServiceDao.update(microService);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        microServiceDao.delete(id);
        microServiceDao.deleteByParentId(id);
        log.debug("删除微服务api id:{}", id);
    }

}
