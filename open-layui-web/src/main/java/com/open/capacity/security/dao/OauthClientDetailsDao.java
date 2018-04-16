package com.open.capacity.security.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.capacity.security.model.OauthClientDetails;

@Mapper
public interface OauthClientDetailsDao {

    @Select("select * from oauth_client_details t where t.id = #{id}")
    OauthClientDetails getById(Long id);

    @Delete("delete from oauth_client_details where id = #{id}")
    int delete(Long id);

    int update(OauthClientDetails oauthClientDetails);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) values(#{clientId}, #{resourceIds}, #{clientSecret}, #{scope}, #{authorizedGrantTypes}, #{webServerRedirectUri}, #{authorities}, #{accessTokenValidity}, #{refreshTokenValidity}, #{additionalInformation}, #{autoapprove})")
    int save(OauthClientDetails oauthClientDetails);
    
    int count(@Param("params") Map<String, Object> params);

    List<OauthClientDetails> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
