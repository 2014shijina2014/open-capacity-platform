package com.open.capacity.security.dao;

import com.open.capacity.security.model.Dict;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DictDao {

    @Select("select * from t_dict t where t.id = #{id}")
    Dict getById(Long id);

    @Delete("delete from t_dict where id = #{id}")
    int delete(Long id);

    int update(Dict dict);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_dict(type, k, val, createTime, updateTime) values(#{type}, #{k}, #{val}, now(), now())")
    int save(Dict dict);

    int count(@Param("params") Map<String, Object> params);

    List<Dict> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
                    @Param("limit") Integer limit);

    @Select("select * from t_dict t where t.type = #{type} and k = #{k}")
    Dict getByTypeAndK(@Param("type") String type, @Param("k") String k);

    @Select("select * from t_dict t where t.type = #{type}")
    List<Dict> listByType(String type);
}
