package com.open.capacity.security.service;

import com.open.capacity.security.model.MicroService;

/**
 * 微服务
 */
public interface MicroServiceService {

    void save(MicroService microService);

    void update(MicroService microService);

    void delete(Long id);
}
