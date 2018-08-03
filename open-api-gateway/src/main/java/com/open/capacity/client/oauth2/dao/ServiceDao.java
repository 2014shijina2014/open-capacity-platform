package com.open.capacity.client.oauth2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ServiceDao {


    /**
     * 根据客户端id查询客户端的api权限
     *
     * @param clientId 客户端id
     * @return
     */
    @Select("select p.* from micro_service p inner join sys_client_permission rp on p.id = rp.permissionId where rp.clientId = #{clientId} order by p.sort")
    List<Map> listByClientId(Long clientId);

    /**
     * 根据客户端id查询客户端信息
     *
     * @param clientId 客户端id
     * @return
     */
    @Select("select * from oauth_client_details t where t.client_id = #{clientId}")
    Map getClient(String clientId);


}
