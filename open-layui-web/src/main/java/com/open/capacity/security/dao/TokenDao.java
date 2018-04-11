package com.open.capacity.security.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.open.capacity.security.model.TokenModel;

@Mapper
public interface TokenDao {

	@Insert("insert into t_token(id, val, expireTime, createTime, updateTime) values (#{id}, #{val}, #{expireTime}, #{createTime}, #{updateTime})")
	int save(TokenModel model);

	@Select("select * from t_token t where t.id = #{id}")
	TokenModel getById(String id);

	@Update("update t_token t set t.val = #{val}, t.expireTime = #{expireTime}, t.updateTime = #{updateTime} where t.id = #{id}")
	int update(TokenModel model);

	@Delete("delete from t_token where id = #{id}")
	int delete(String id);
}
