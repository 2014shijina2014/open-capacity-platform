package com.open.capacity.activiti.mapper;

import com.open.capacity.activiti.entity.ActAssignee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:53]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Mapper
public interface ActAssigneeMapper {

    int deleteByPrimaryKey(String id);

    int insert(ActAssignee record);

    int insertSelective(ActAssignee record);

    ActAssignee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActAssignee record);

    int updateByPrimaryKey(ActAssignee record);

    int deleteByNodeId(String nodeId);


}
