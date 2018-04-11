package com.open.capacity.quartz.service;

import org.quartz.JobDataMap;
import org.quartz.SchedulerException;

import com.open.capacity.quartz.model.JobModel;

public interface JobService {

	void saveJob(JobModel jobModel);

	void doJob(JobDataMap jobDataMap);

	void deleteJob(Long id) throws SchedulerException;
}
