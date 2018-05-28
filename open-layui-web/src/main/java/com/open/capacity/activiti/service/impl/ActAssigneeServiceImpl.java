package com.open.capacity.activiti.service.impl;

import com.open.capacity.activiti.entity.ActAssignee;
import com.open.capacity.activiti.mapper.ActAssigneeMapper;
import com.open.capacity.activiti.service.ActAssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 20:15]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Service
public class ActAssigneeServiceImpl implements ActAssigneeService {
    @Autowired
    ActAssigneeMapper actAssigneeMapper;

    @Override
    public int deleteByNodeId(String nodeId) {
        return actAssigneeMapper.deleteByNodeId(nodeId);
    }

    @Override
    public List<ActAssignee> selectListByPage(ActAssignee record) {
        return actAssigneeMapper.selectListByPage(record);
    }

}
