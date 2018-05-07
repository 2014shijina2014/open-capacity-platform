package com.open.capacity.controller.annotation;


import java.lang.annotation.*;

/**
 * 权限限制
 *
 * @author xuxueli 2015-12-12 18:29:02
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermessionLimit {

    /**
     * 登录拦截 (默认拦截)
     */
    boolean limit() default true;

}