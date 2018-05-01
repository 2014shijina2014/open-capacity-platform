package com.open.capacity.db.config.dynamic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.open.capacity.db.config.dynamic.annotation.DataSource;
import com.open.capacity.db.config.dynamic.config.util.DataSourceHolder;
import com.open.capacity.db.config.dynamic.config.util.DataSourceKey;

/**
 * 切换数据源Advice
 */
@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DataSource ds) throws Throwable {
        String dsId = ds.name();
        try {
            DataSourceKey dataSourceKey = DataSourceKey.valueOf(dsId);
            logger.debug("Use DataSource : {}", ds.name(), point.getSignature());
            DataSourceHolder.setDataSourceKey(dataSourceKey);
        } catch (Exception e) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.name(), point.getSignature());
        }


    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, DataSource ds) {
        logger.debug("Revert DataSource : ", ds.name(), point.getSignature());
        DataSourceHolder.clearDataSourceKey();
    }

}