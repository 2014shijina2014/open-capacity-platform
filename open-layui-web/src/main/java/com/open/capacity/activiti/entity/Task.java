package com.open.capacity.activiti.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:23]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */

@Getter
@Setter
@ToString
public class Task {
    private String id;
    private String name;
    private Date createTime;
    private String assignee;
    private String processInstanceId;//流程实例id
    private String processDefinitionId;//流程定义id
    private String description;
    private String category;

    private String userName;
    private String reason;

    public Task() {
    }
    public Task(org.activiti.engine.task.Task t) {
        this.id=t.getId();
        this.name=t.getName();
        this.createTime=t.getCreateTime();
        this.assignee=t.getAssignee();
        this.processInstanceId=t.getProcessInstanceId();
        this.processDefinitionId=t.getProcessDefinitionId();
        this.description=t.getDescription();
        this.category=t.getCategory();
    }
}
