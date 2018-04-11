package com.open.capacity.quartz.service.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.open.capacity.quartz.dao.JobDao;
import com.open.capacity.quartz.job.SpringBeanJob;
import com.open.capacity.quartz.model.JobModel;
import com.open.capacity.quartz.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private Scheduler scheduler;
	@Autowired
	private ApplicationContext applicationContext;
	private static final String JOB_DATA_KEY = "JOB_DATA_KEY";
	@Autowired
	private JobDao jobDao;

	@Override
	public void saveJob(JobModel jobModel) {
		checkJobModel(jobModel);
		String name = jobModel.getJobName();

		JobKey jobKey = JobKey.jobKey(name);
		JobDetail jobDetail = JobBuilder.newJob(SpringBeanJob.class).storeDurably()
				.withDescription(jobModel.getDescription()).withIdentity(jobKey).build();

		jobDetail.getJobDataMap().put(JOB_DATA_KEY, jobModel);

		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobModel.getCron());
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name).withSchedule(cronScheduleBuilder)
				.forJob(jobKey).build();

		try {
			boolean exists = scheduler.checkExists(jobKey);
			if (exists) {
				scheduler.rescheduleJob(new TriggerKey(name), cronTrigger);
				scheduler.addJob(jobDetail, true);
			} else {
				scheduler.scheduleJob(jobDetail, cronTrigger);
			}

			JobModel model = jobDao.getByName(name);
			if (model == null) {
				jobDao.save(jobModel);
			} else {
				jobDao.update(jobModel);
			}
		} catch (SchedulerException e) {
			log.error("新增或修改job异常", e);
		}
	}

	private void checkJobModel(JobModel jobModel) {
		String springBeanName = jobModel.getSpringBeanName();
		boolean flag = applicationContext.containsBean(springBeanName);
		if (!flag) {
			throw new IllegalArgumentException("bean：" + springBeanName + "不存在，bean名如userServiceImpl,首字母小写");
		}

		Object object = applicationContext.getBean(springBeanName);
		Class<?> clazz = object.getClass();
		if (AopUtils.isAopProxy(object)) {
			clazz = clazz.getSuperclass();
		}

		String methodName = jobModel.getMethodName();
		Method[] methods = clazz.getDeclaredMethods();

		Set<String> names = new HashSet<>();
		Arrays.asList(methods).parallelStream().forEach(m -> {
			Class<?>[] classes = m.getParameterTypes();
			if (classes.length == 0) {
				names.add(m.getName());
			}
		});

		if (names.size() == 0) {
			throw new IllegalArgumentException("该bean没有无参方法");
		}

		if (!names.contains(methodName)) {
			throw new IllegalArgumentException("未找到无参方法" + methodName + ",该bean所有方法名为：" + names);
		}
	}

	@Override
	public void doJob(JobDataMap jobDataMap) {
		JobModel jobModel = (JobModel) jobDataMap.get(JOB_DATA_KEY);

		String beanName = jobModel.getSpringBeanName();
		String methodName = jobModel.getMethodName();
		Object object = applicationContext.getBean(beanName);

		try {
			log.info("job:bean：{}，方法名：{}", beanName, methodName);
			Method method = object.getClass().getDeclaredMethod(methodName);
			method.invoke(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除job
	 * 
	 * @throws SchedulerException
	 */
	@Override
	public void deleteJob(Long id) throws SchedulerException {
		JobModel jobModel = jobDao.getById(id);

		if (jobModel.getIsSysJob() != null && jobModel.getIsSysJob()) {
			throw new IllegalArgumentException("该job是系统任务，不能删除，因为此job是在代码里初始化的，删除该类job请先确保相关代码已经去除");
		}

		String jobName = jobModel.getJobName();
		JobKey jobKey = JobKey.jobKey(jobName);

		scheduler.pauseJob(jobKey);
		scheduler.unscheduleJob(new TriggerKey(jobName));
		scheduler.deleteJob(jobKey);

		jobModel.setStatus(0);
		jobDao.update(jobModel);
	}

}
