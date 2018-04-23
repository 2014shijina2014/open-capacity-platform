package com.open.capacity.db.config.dynamic.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.open.capacity.db.config.dynamic.config.util.DataSourceKey;
import com.open.capacity.db.config.dynamic.config.util.DynamicDataSource;

/**
 * 定义数据源
 *
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年04月23日 下午20:01:06 类说明
 */
@Configuration
@PropertySource("classpath:jdbc.test.properties")
@ConditionalOnProperty(name = { "spring.datasource.enable.dynamic" }, matchIfMissing = false, havingValue = "true")
public class DynamicDataSourceConfig {

	private Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

	// crm库
	@Value("${spring.datasource.primary.url:#{null}}")
	private String primaryDbUrl;
	@Value("${spring.datasource.primary.username: #{null}}")
	private String primaryUsername;
	@Value("${spring.datasource.primary.password:#{null}}")
	private String primaryPassword;

	// bill库
	@Value("${spring.datasource.secondary.url:#{null}}")
	private String secondaryDbUrl;
	@Value("${spring.datasource.secondary.username: #{null}}")
	private String secondaryUsername;
	@Value("${spring.datasource.secondary.password:#{null}}")
	private String secondaryPassword;

	// 公共配置
	@Value("${spring.datasource.driverClassName:#{null}}")
	private String driverClassName;
	@Value("${spring.datasource.initialSize:#{null}}")
	private Integer initialSize;
	@Value("${spring.datasource.minIdle:#{null}}")
	private Integer minIdle;
	@Value("${spring.datasource.maxActive:#{null}}")
	private Integer maxActive;
	@Value("${spring.datasource.maxWait:#{null}}")
	private Integer maxWait;
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis:#{null}}")
	private Integer timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.minEvictableIdleTimeMillis:#{null}}")
	private Integer minEvictableIdleTimeMillis;
	@Value("${spring.datasource.validationQuery:#{null}}")
	private String validationQuery;
	@Value("${spring.datasource.testWhileIdle:#{null}}")
	private Boolean testWhileIdle;
	@Value("${spring.datasource.testOnBorrow:#{null}}")
	private Boolean testOnBorrow;
	@Value("${spring.datasource.testOnReturn:#{null}}")
	private Boolean testOnReturn;
	@Value("${spring.datasource.poolPreparedStatements:#{null}}")
	private Boolean poolPreparedStatements;
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize:#{null}}")
	private Integer maxPoolPreparedStatementPerConnectionSize;
	@Value("${spring.datasource.filters:#{null}}")
	private String filters;
	@Value("{spring.datasource.connectionProperties:#{null}}")
	private String connectionProperties;

	// 不需要纳入spring容器
	public DataSource crmDataSource() {
		DruidDataSource crmDataSource = new DruidDataSource();
		crmDataSource.setUrl(this.primaryDbUrl);
		crmDataSource.setUsername(this.primaryUsername);// 用户名
		crmDataSource.setPassword(this.primaryPassword);// 密码
		crmDataSource.setDriverClassName(driverClassName);
		this.setCommons(crmDataSource);
		return crmDataSource;
	}

	// 不需要纳入spring容器
	public DataSource billDataSource() {
		DruidDataSource billDataSource = new DruidDataSource();
		billDataSource.setUrl(secondaryDbUrl);
		billDataSource.setUsername(secondaryUsername);// 用户名
		billDataSource.setPassword(secondaryPassword);// 密码
		billDataSource.setDriverClassName(driverClassName);

		this.setCommons(billDataSource);

		return billDataSource;
	}

	@Bean // 只需要纳入动态数据源到spring容器
	@Primary
	public DataSource dataSource() {
		DynamicDataSource dataSource = new DynamicDataSource();
		DataSource crmDataSource = this.crmDataSource();
		DataSource billDataSource = this.billDataSource();
		dataSource.addDataSource(DataSourceKey.crm, crmDataSource);
		dataSource.addDataSource(DataSourceKey.bill, billDataSource);
		dataSource.setDefaultTargetDataSource(crmDataSource);

		return dataSource;
	}

	@Bean
	public StatFilter statFilter() {
		StatFilter statFilter = new StatFilter();
		statFilter.setLogSlowSql(true);
		statFilter.setMergeSql(true);
		statFilter.setSlowSqlMillis(1000);

		return statFilter;
	}

	@Bean
	public WallFilter wallFilter() {
		WallFilter wallFilter = new WallFilter();

		// 允许执行多条SQL
		WallConfig config = new WallConfig();
		config.setMultiStatementAllow(true);
		wallFilter.setConfig(config);

		return wallFilter;
	}

	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		return servletRegistrationBean;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {

		return new JdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {

		return new NamedParameterJdbcTemplate(dataSource);
	}

	private void setCommons(DruidDataSource dataSource) {
		// configuration
		if (initialSize != null) {
			dataSource.setInitialSize(initialSize);
		}
		if (minIdle != null) {
			dataSource.setMinIdle(minIdle);
		}
		if (maxActive != null) {
			dataSource.setMaxActive(maxActive);
		}
		if (maxWait != null) {
			dataSource.setMaxWait(maxWait);
		}
		if (timeBetweenEvictionRunsMillis != null) {
			dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		}
		if (minEvictableIdleTimeMillis != null) {
			dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		}
		if (validationQuery != null) {
			dataSource.setValidationQuery(validationQuery);
		}
		if (testWhileIdle != null) {
			dataSource.setTestWhileIdle(testWhileIdle);
		}
		if (testOnBorrow != null) {
			dataSource.setTestOnBorrow(testOnBorrow);
		}
		if (testOnReturn != null) {
			dataSource.setTestOnReturn(testOnReturn);
		}
		if (poolPreparedStatements != null) {
			dataSource.setPoolPreparedStatements(poolPreparedStatements);
		}
		if (maxPoolPreparedStatementPerConnectionSize != null) {
			dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		}

		if (connectionProperties != null) {
			dataSource.setConnectionProperties(connectionProperties);
		}

		List<Filter> filters = new ArrayList<>();
		filters.add(statFilter());
		filters.add(wallFilter());
		dataSource.setProxyFilters(filters);
	}

	@Bean // 将数据源纳入spring事物管理
	@Primary
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
