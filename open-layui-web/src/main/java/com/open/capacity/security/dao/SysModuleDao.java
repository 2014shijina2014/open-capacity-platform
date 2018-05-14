package com.open.capacity.security.dao;

import com.open.capacity.security.model.SysModule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 模块管理
 **/
@Mapper
@Repository
public interface SysModuleDao {

	Integer count(@Param("params") Map<String, Object> params);

	List<SysModule> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
					   @Param("limit") Integer limit);

	@Select("select * from sys_module t where t.id = #{id}")
	SysModule getById(Long id);

	@Delete("delete from sys_module where id = #{id}")
	int deleteById(Long id);

	int insert(SysModule sysModule);

	int update(SysModule sysModule);

	@Select("select * from sys_module ORDER BY sort")
	List<SysModule> getAll();
}
