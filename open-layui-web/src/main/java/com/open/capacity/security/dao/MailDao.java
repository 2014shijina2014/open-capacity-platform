package com.open.capacity.security.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.capacity.security.model.Mail;
import com.open.capacity.security.model.MailTo;

@Mapper
public interface MailDao {

	@Select("select * from t_mail t where t.id = #{id}")
	Mail getById(Long id);

//	@Delete("delete from t_mail where id = #{id}")
//	int delete(Long id);

//	@Update("update t_mail t set subject = #{subject}, content = #{content}, updateTime = now() where t.id = #{id}")
//	int update(Mail mail);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_mail(userId, subject, content, createTime, updateTime) values(#{userId}, #{subject}, #{content}, now(), now())")
	int save(Mail mail);

	@Insert("insert into t_mail_to(mailId, toUser, status) values(#{mailId}, #{toUser}, #{status})")
	int saveToUser(@Param("mailId") Long mailId, @Param("toUser") String toUser, @Param("status") int status);

	@Select("select t.* from t_mail_to t where t.mailId = #{mailId}")
	List<MailTo> getToUsers(Long mailId);

	int count(@Param("params") Map<String, Object> params);

	List<Mail> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
			@Param("limit") Integer limit);
}
