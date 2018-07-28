package com.open.capacity.security.service;

import com.open.capacity.security.dao.MicroServiceDao;
import com.open.capacity.security.model.MicroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MicroServiceService {

    private static final Logger log = LoggerFactory.getLogger(MicroServiceService.class);

    @Autowired
    private MicroServiceDao microServiceDao;

    public void save(MicroService microService) {
        microServiceDao.save(microService);

        log.debug("新增服务{}", microService.getName());
    }


    public void update(MicroService microService) {
        microServiceDao.update(microService);
    }


    @Transactional
    public void delete(Long id) {
        microServiceDao.delete(id);
        microServiceDao.deleteByParentId(id);
        log.debug("删除微服务api id:{}", id);
    }

}
