package vip.justlive.frost.core.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring beans 工具
 * 
 * @author wubo
 *
 */
@Component
public class SpringBeansHolder implements ApplicationContextAware {

  static final ConcurrentMap<Class<?>, BeanFactory> BEAN_FACTORY_MAP = new ConcurrentHashMap<>();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    BEAN_FACTORY_MAP.put(ApplicationContext.class, applicationContext);
  }

  public static <T> T getBean(String name, Class<T> clazz) {
    return BEAN_FACTORY_MAP.get(ApplicationContext.class).getBean(name, clazz);
  }

  public static <T> T getBean(Class<T> clazz) {
    return BEAN_FACTORY_MAP.get(ApplicationContext.class).getBean(clazz);
  }

}
