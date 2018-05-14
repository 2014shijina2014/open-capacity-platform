package com.open.capacity.quartz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.capacity.quartz.model.JobModel;

@Mapper
public interface JobDao {


	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_job(jobName, description, cron, springBeanName, methodName, isSysJob, status, createTime, updateTime) values(#{jobName}, #{description}, #{cron}, #{springBeanName}, #{methodName}, #{isSysJob}, 1, now(), now())")
	int save(JobModel jobModel);

	@Select("select * from t_job t where t.id = #{id}")
	JobModel getById(Long id);

	@Select("select * from t_job t where t.jobName = #{jobName}")
	JobModel getByName(String jobName);

	int update(JobModel jobModel);

	int count(@Param("params") Map<String, Object> params);

	List<JobModel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
			@Param("limit") Integer limit);
}
