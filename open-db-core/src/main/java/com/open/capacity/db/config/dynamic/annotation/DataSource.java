package com.open.capacity.db.config.dynamic.annotation;

import java.lang.annotation.*;

/**
 * 数据源选择
 *
 * @author owen
 * @create 2017年7月2日
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name();
}