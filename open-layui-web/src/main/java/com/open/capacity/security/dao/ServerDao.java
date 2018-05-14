package com.open.capacity.security.dao;

import com.open.capacity.security.model.SysServer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 服务管理
 **/
@Mapper
@Repository
public interface ServerDao {

	@Select("select t.*,a.name as moduleName from sys_server t left join sys_module a on t.moduleId = a.id where t.moduleId = #{moduleId}")
	List<SysServer> listAll(Long moduleId);

	@Select("select * from sys_server t where t.id = #{id}")
	SysServer getById(Long id);

	@Insert("insert into sys_server(parentId,moduleId, name,path,description,sort) values(#{parentId},#{moduleId}, #{name}, #{path}, #{description}, #{sort})")
	int save(SysServer SysServer);

	@Update("update sys_server t set parentId = #{parentId},moduleId = #{moduleId}, name = #{name}, path = #{path}, description = #{description}, sort = #{sort} where t.id = #{id}")
	int update(SysServer SysServer);

	@Delete("delete from sys_server where id = #{id}")
	int delete(Long id);

	@Delete("delete from sys_server where parentId = #{id}")
	int deleteByParentId(Long id);
}
