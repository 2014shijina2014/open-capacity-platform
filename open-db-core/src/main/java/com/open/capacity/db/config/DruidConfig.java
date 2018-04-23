package com.open.capacity.db.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年04月23日 下午20:01:06 类说明 *
 */

@Configuration
@ConditionalOnProperty(name = { "spring.datasource.enable.dynamic" }, matchIfMissing = true)
public class DruidConfig {

	// 将druid纳入监控步骤如下
	// 1通过springboot配置文件注入datasource中
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = false)
	public DataSource druidDataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}

	// 2.StatViewServlet注入到spring中
	// Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
	// 这个StatViewServlet的用途包括：
	// 提供监控信息展示的html页面
	// 提供监控信息的JSON API
	// 注意：使用StatViewServlet，建议使用druid 0.2.6以上版本。
	// 注入第三方没有注解的servlet
	@Bean
	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = false)
	public ServletRegistrationBean druidServlet() { // 主要实现WEB监控的配置处理
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*"); // 现在要进行druid监控的配置处理操作
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1,130.75.131.208,134.224.249.39,134.224.249.33"); // 白名单
		servletRegistrationBean.addInitParameter("deny", "192.168.28.200"); // 黑名单
		servletRegistrationBean.addInitParameter("loginUsername", "owen"); // 用户名
		servletRegistrationBean.addInitParameter("loginPassword", "1q2w3e4r"); // 密码
		servletRegistrationBean.addInitParameter("resetEnable", "false"); // 是否可以重置数据源
		return servletRegistrationBean;
	}

	// 3.对请求进行过滤
	// WebStatFilter注入到spring容器中
	// 注入第三方没有注解的过滤器
	@Bean
	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = false)
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*"); // 所有请求进行监控处理
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
		return filterRegistrationBean;
	}

}
