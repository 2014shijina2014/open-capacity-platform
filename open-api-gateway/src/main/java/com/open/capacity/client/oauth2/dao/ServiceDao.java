package com.open.capacity.client.oauth2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ServiceDao {

 

	@Select("select p.* from sys_services p inner join sys_client_permission rp on p.id = rp.permissionId where rp.clientId = #{clientId} order by p.sort")
	List<Map> listByClientId(Long clientId);

	@Select("select * from oauth_client_details t where t.client_id = #{clientId}")
	Map getClient(String clientId);

 
}
