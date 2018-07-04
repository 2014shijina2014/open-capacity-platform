package com.open.capacity.security.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.open.capacity.security.model.Client;
import com.open.capacity.security.model.Role;

@Mapper
public interface ClientDao {

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) values(#{clientId}, #{resourceIds}, #{clientSecret}, #{scope}, #{authorizedGrantTypes}, #{webServerRedirectUri}, #{authorities}, #{accessTokenValidity}, #{refreshTokenValidity}, #{additionalInformation}, #{autoapprove})")
	int save(Client client);

	int count(@Param("params") Map<String, Object> params);

	List<Client> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	@Select("select id id , client_id clientId , resource_ids resourceIds ,client_secret clientSecret ,web_server_redirect_uri webServerRedirectUri  from oauth_client_details t where t.id = #{id}")
	Client getById(Long id);

	@Select("select * from oauth_client_details t where t.client_id = #{clientId}")
	Client getClient(String clientId);

	@Update("update oauth_client_details t set t.client_secret = #{clientSecret}  where t.id = #{id}")
	int update(Client client);

	@Select("select * from sys_role r inner join sys_role_user ru on r.id = ru.roleId where ru.userId = #{userId}")
	List<Client> listByUserId(Long userId);

	@Delete("delete from sys_client_permission where clientId = #{clientId}")
	int deleteClientPermission(Long clientId);

	int saveClientPermission(@Param("clientId") Long clientId, @Param("permissionIds") List<Long> permissionIds);

	@Delete("delete from oauth_client_details where id = #{id}")
	int delete(Long id);

	@Delete("delete from sys_role_user where roleId = #{clientId}")
	int deleteRoleUser(Long clientId);

}
