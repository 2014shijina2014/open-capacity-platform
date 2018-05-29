package com.open.capacity.activiti.service;

import com.open.capacity.activiti.entity.ActAssignee;

import java.util.List;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 20:14]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
public interface ActAssigneeService {
    int deleteByNodeId(String nodeId);

    List<ActAssignee> selectListByPage(ActAssignee record);


    int insertSelective( ActAssignee record);



}
