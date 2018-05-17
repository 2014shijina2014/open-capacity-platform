package vip.justlive.frost.core.job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记当前类是job
 * 
 * @author wubo
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Job {

  /**
   * job名称
   * 
   * @return
   */
  String value() default "";

  /**
   * 描述
   * 
   * @return
   */
  String desc() default "";
}
