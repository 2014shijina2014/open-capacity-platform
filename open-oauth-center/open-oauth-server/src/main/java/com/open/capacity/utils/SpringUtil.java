package com.open.capacity.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * spring获取bean工具类
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年3月20日 下午10:13:18 类说明
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    /**
     * 获取某个类型的Bean
     *
     * @param cla Bean的type
     * @param <T> 泛型 返回的bean的类型
     * @return
     * @Description 适合单例Bean
     */
    public static <T> T getBean(Class<T> cla) {
        return applicationContext.getBean(cla);
    }

    /**
     * 获取Spring容器中Bean
     *
     * @param name Bean的name
     * @param cal  Bean的type
     * @param <T>  泛型 返回的bean的类型
     * @return
     */
    public static <T> T getBean(String name, Class<T> cal) {
        return applicationContext.getBean(name, cal);
    }

    /**
     * @param key 获取配置文件中的值
     * @return
     */
    public static String getProperty(String key) {
        return applicationContext.getBean(Environment.class).getProperty(key);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }
}

