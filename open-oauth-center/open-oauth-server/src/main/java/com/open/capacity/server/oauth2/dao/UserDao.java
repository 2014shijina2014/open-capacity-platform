package com.open.capacity.server.oauth2.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

	 

	@Select("select * from sys_user t where t.username = #{username}")
	Map getUser(String username);

	 
}
