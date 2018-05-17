package com.xxl.job.admin.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.xxl.job.admin.component.SpringJobFactory;

/**
 * @author owen 定时任务配置
 *
 */
@Configuration
public class QuartzConfig {
	@Autowired
	private SpringJobFactory springJobFactory;
	@Autowired
	private DataSource druidDataSource ;
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		try {
			schedulerFactoryBean.setDataSource(druidDataSource);
			schedulerFactoryBean.setQuartzProperties(quartzProperties());
			schedulerFactoryBean.setJobFactory(springJobFactory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedulerFactoryBean;
	}

	@Bean(name = "scheduler")
	public Scheduler scheduler() throws IOException, SchedulerException {
		return schedulerFactoryBean().getScheduler();
	}

	/**
	 * 设置quartz属性
	 *
	 * @throws IOException
	 */
	public Properties quartzProperties() throws IOException {
		Properties prop = new Properties();
		// prop.setProperty("org.quartz.scheduler.rmi.export", "false");
		// prop.setProperty("org.quartz.scheduler.rmi.proxy", "false");
		// prop.setProperty("org.quartz.scheduler.wrapJobExecutionInUserTransaction",
		// "false");
		prop.setProperty("org.quartz.scheduler.instanceName", "scheduler");
		prop.setProperty("org.quartz.scheduler.instanceId", "AUTO");
		// prop.setProperty("org.quartz.scheduler.skipUpdateCheck", "true");
		// prop.setProperty("org.quartz.scheduler.jobFactory.class",
		// "org.quartz.simpl.SimpleJobFactory");
		prop.setProperty("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
		prop.setProperty("org.quartz.jobStore.misfireThreshold", "60000");
		prop.setProperty("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
		prop.setProperty("org.quartz.jobStore.tablePrefix", "XXL_JOB_QRTZ_");
		prop.setProperty("org.quartz.jobStore.isClustered", "true");// 是否集群
		prop.setProperty("org.quartz.jobStore.clusterCheckinInterval", "5000");
		prop.setProperty("org.quartz.jobStore.dataSource", "quartzDataSource");
		prop.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		prop.setProperty("org.quartz.threadPool.threadPriority", "5");
		prop.setProperty("org.quartz.threadPool.threadCount", "15");
		prop.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "1000");
		return prop;
	}
}
