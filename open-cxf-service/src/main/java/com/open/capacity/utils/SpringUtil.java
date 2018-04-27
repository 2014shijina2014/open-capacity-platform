package com.open.capacity.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2018年04月23日 上午20:01:06 类说明
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	@Autowired  
	private StringEncryptor stringEncryptor;  
	  
	public void encryptPwd() {  
	    String result = stringEncryptor.encrypt("sunny2q20");  
	    System.out.println("==================");   
	    System.out.println(result);   
	    System.out.println("==================");  
	}  

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> cla) {
		return applicationContext.getBean(cla);
	}

	public static <T> T getBean(String name, Class<T> cal) {
		return applicationContext.getBean(name, cal);
	}

	public static String getProperty(String key) {
		return applicationContext.getBean(Environment.class).getProperty(key);
	}
}
