package com.open.capacity.security.dao;

import com.open.capacity.security.model.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ServiceDao {

    @Select("select * from sys_services t order by t.sort")
    List<Permission> listAll();

    @Select("select * from sys_services t where t.type = 1 order by t.sort")
    List<Permission> listParents();

    @Select("select distinct p.* from sys_services p inner join sys_client_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = #{userId} order by p.sort")
    List<Permission> listByUserId(Long userId);

    @Select("select p.* from sys_services p inner join sys_client_permission rp on p.id = rp.permissionId where rp.clientId = #{clientId} order by p.sort")
    List<Permission> listByClientId(Long clientId);

    @Select("select * from sys_services t where t.id = #{id}")
    Permission getById(Long id);

    @Insert("insert into sys_services(parentId, name, css, href, type, permission, sort) values(#{parentId}, #{name}, #{css}, #{href}, #{type}, #{permission}, #{sort})")
    int save(Permission permission);

    @Update("update sys_services t set parentId = #{parentId}, name = #{name}, css = #{css}, href = #{href}, type = #{type}, permission = #{permission}, sort = #{sort} where t.id = #{id}")
    int update(Permission permission);

    @Delete("delete from sys_services where id = #{id}")
    int delete(Long id);

    @Delete("delete from sys_services where parentId = #{id}")
    int deleteByParentId(Long id);

    @Select("select ru.userId from sys_role_permission rp inner join sys_role_user ru on ru.roleId = rp.roleId where rp.permissionId = #{permissionId}")
    Set<Long> listUserIds(Long permissionId);
}
