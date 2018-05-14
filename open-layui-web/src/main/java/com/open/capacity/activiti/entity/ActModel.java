package com.open.capacity.activiti.entity;


import lombok.Getter;
import lombok.Setter;
import org.activiti.engine.repository.Model;

import java.util.Date;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:19]
 * @Description: [ 模型列表 ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Getter
@Setter
public class ActModel {

    private String id;
    private String name;
    private String key;
    private String category;
    private Date createTime;
    private Date lastUpdateTime;
    private Integer version;
    private String metaInfo;
    private String deploymentId;
    private String tenantId;
    private boolean hasEditorSource;


    public ActModel() {
    }

    public ActModel(Model model) {
        this.id = model.getId();
        this.name = model.getName();
        this.key = model.getKey();
        this.category = model.getCategory();
        this.createTime = model.getCreateTime();
        this.lastUpdateTime = model.getLastUpdateTime();
        this.version = model.getVersion();
        this.metaInfo = model.getMetaInfo();
        this.deploymentId = model.getDeploymentId();
        this.tenantId = model.getTenantId();
        this.hasEditorSource = model.hasEditorSource();
    }
}
