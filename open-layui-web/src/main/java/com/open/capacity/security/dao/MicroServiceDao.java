package com.open.capacity.security.dao;

import com.open.capacity.security.model.MicroService;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface MicroServiceDao {

    @Select("select * from micro_service t order by t.sort")
    List<MicroService> listAll();

    @Select("select * from micro_service t where t.parentId = 0 order by t.sort")
    List<MicroService> listParents();

    @Select("select distinct p.* from micro_service p inner join sys_client_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = #{userId} order by p.sort")
    List<MicroService> listByUserId(Long userId);

    @Select("select p.* from micro_service p inner join sys_client_permission rp on p.id = rp.permissionId where rp.clientId = #{clientId} order by p.sort")
    List<MicroService> listByClientId(Long clientId);

    @Select("select * from micro_service t where t.id = #{id}")
    MicroService getById(Long id);

    @Insert("insert into micro_service(parentId, name, href, permission, sort) values(#{parentId}, #{name}, #{href}, #{permission}, #{sort})")
    int save(MicroService permission);

    @Update("update micro_service t set parentId = #{parentId}, name = #{name}, href = #{href}, permission = #{permission}, sort = #{sort} where t.id = #{id}")
    int update(MicroService permission);

    @Delete("delete from micro_service where id = #{id}")
    int delete(Long id);

    @Delete("delete from micro_service where parentId = #{id}")
    int deleteByParentId(Long id);

    @Select("select ru.userId from sys_role_permission rp inner join sys_role_user ru on ru.roleId = rp.roleId where rp.permissionId = #{permissionId}")
    Set<Long> listUserIds(Long permissionId);
}
