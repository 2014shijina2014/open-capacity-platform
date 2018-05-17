package vip.justlive.frost.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;
import vip.justlive.common.base.exception.Exceptions;
import vip.justlive.common.base.util.ReflectUtils;
import vip.justlive.frost.core.job.IJob;

/**
 * 脚本任务工厂
 * 
 * @author wubo
 *
 */
@Slf4j
public class ScriptJobFactory {

  ScriptJobFactory() {}

  private static final GroovyClassLoader LOADER = new GroovyClassLoader();

  private static final Cache<String, IJob> CACHE = Caffeine.newBuilder().softValues().build();

  /**
   * 解析脚本
   * 
   * @param script
   */
  public static IJob parse(String script) {
    Class<?> clazz = LOADER.parseClass(script);
    Object obj;
    try {
      obj = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw Exceptions.wrap(e);
    }
    if (obj instanceof IJob) {
      IJob job = IJob.class.cast(obj);
      inject(job);
      return job;
    }
    throw Exceptions.fail("30004", "脚本未实现IJob接口");
  }

  /**
   * 解析带版本号的脚本
   * 
   * @param script
   * @param versionId
   * @return
   */
  public static IJob parse(String script, String versionId) {
    if (versionId == null) {
      return parse(script);
    }

    IJob job = CACHE.getIfPresent(versionId);
    if (job != null) {
      return job;
    }

    job = parse(script);
    CACHE.put(versionId, job);
    return job;
  }

  static void inject(IJob job) {
    Field[] fields = ReflectUtils.getAllDeclaredFields(job.getClass());
    for (Field field : fields) {
      if (Modifier.isStatic(field.getModifiers())) {
        continue;
      }
      Object fieldBean = null;
      if (field.isAnnotationPresent(Resource.class)) {
        fieldBean = lookupResource(field);
      } else if (field.isAnnotationPresent(Autowired.class)) {
        fieldBean = lookupAutowired(field);
      }
      if (fieldBean != null) {
        field.setAccessible(true);
        try {
          field.set(job, fieldBean);
        } catch (IllegalArgumentException | IllegalAccessException e) {
          log.error(e.getMessage(), e);
        }
      }
    }
  }

  static Object lookupResource(Field field) {
    Resource resource = AnnotationUtils.getAnnotation(field, Resource.class);
    if (StringUtils.hasText(resource.name())) {
      return SpringBeansHolder.getBean(resource.name(), field.getType());
    } else {
      return SpringBeansHolder.getBean(field.getType());
    }
  }

  static Object lookupAutowired(Field field) {
    Qualifier qualifier = AnnotationUtils.getAnnotation(field, Qualifier.class);
    if (qualifier != null && StringUtils.hasText(qualifier.value())) {
      return SpringBeansHolder.getBean(qualifier.value(), field.getType());
    } else {
      return SpringBeansHolder.getBean(field.getType());
    }
  }
}
