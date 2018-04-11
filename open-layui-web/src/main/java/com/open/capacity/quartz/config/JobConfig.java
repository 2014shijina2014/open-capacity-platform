package com.open.capacity.quartz.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class JobConfig {

	public static final String KEY = "applicationContextSchedulerContextKey";

	@Bean("adminQuartzScheduler")
	public SchedulerFactoryBean quartzScheduler(DataSource dataSource) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setDataSource(dataSource);

		// quartz参数
		Properties prop = new Properties();
		prop.put("org.quartz.scheduler.instanceName", "OpenScheduler");
		prop.put("org.quartz.scheduler.instanceId", "AUTO");
		// 线程池配置
		prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		prop.put("org.quartz.threadPool.threadCount", "5");
		prop.put("org.quartz.threadPool.threadPriority", "2");
		// JobStore配置
		prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
		// 集群配置
		prop.put("org.quartz.jobStore.isClustered", "true");
		prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
		prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");

		prop.put("org.quartz.jobStore.misfireThreshold", "12000");
		prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
		factory.setQuartzProperties(prop);

		factory.setSchedulerName("OpenScheduler");
		// 延时启动
		factory.setStartupDelay(5);
		factory.setApplicationContextSchedulerContextKey("applicationContextKey");
		// 可选，QuartzScheduler
		// 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
		factory.setOverwriteExistingJobs(true);
		// 设置自动启动，默认为true
		factory.setAutoStartup(true);
		return factory;
	}

//	@Autowired
//	private JobService jobService;
//	@Autowired
//	private TaskExecutor taskExecutor;
//
//	/**
//	 * 初始化一个定时删除日志的任务
//	 */
//	@PostConstruct
//	public void initDeleteLogsJob() {
//		taskExecutor.execute(() -> {
//			JobModel jobModel = new JobModel();
//			jobModel.setJobName("delete-logs-job");
//			jobModel.setCron("0 0 0 * * ?");
//			jobModel.setDescription("定时删除三个月前日志");
//			jobModel.setSpringBeanName("sysLogServiceImpl");
//			jobModel.setMethodName("deleteLogs");
//			jobModel.setIsSysJob(true);
//			jobModel.setStatus(1);
//
//			jobService.saveJob(jobModel);
//		});
//	}

}
