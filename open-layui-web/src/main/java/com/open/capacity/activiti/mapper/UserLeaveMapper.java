package com.open.capacity.activiti.mapper;

import com.open.capacity.activiti.entity.UserLeave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 20:05]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Mapper
public interface UserLeaveMapper {

    int deleteByPrimaryKey(String id);

    int insert(UserLeave record);

    int insertSelective(UserLeave record);

    UserLeave selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserLeave record);

    int updateByPrimaryKey(UserLeave record);

    List<UserLeave> selectListByPage(UserLeave userLeave);
}
