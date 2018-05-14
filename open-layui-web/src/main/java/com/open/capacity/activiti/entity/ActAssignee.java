package com.open.capacity.activiti.entity;

import java.io.Serializable;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:17]
 * @Description: [ 任务节点和代理人、候选人、候选组的绑定实体 ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
public class ActAssignee implements Serializable {

    private String id;

    private String sid;

    private String assignee;

    private String roleId;

    private Integer assigneeType;

    private String activtiName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee == null ? null : assignee.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Integer getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(Integer assigneeType) {
        this.assigneeType = assigneeType;
    }

    public String getActivtiName() {
        return activtiName;
    }

    public void setActivtiName(String activtiName) {
        this.activtiName = activtiName == null ? null : activtiName.trim();
    }

    public ActAssignee() {
    }

    public ActAssignee(String sid) {
        this.sid = sid;
    }
}
