package com.open.capacity.activiti.entity;


import lombok.Getter;
import lombok.Setter;
import org.activiti.engine.repository.Deployment;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:18]
 * @Description: [ 流程部署表 ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Getter
@Setter
public class ActDeployment implements Serializable {
    private String id;
    private String name;
    private Date deploymentTime;
    private String category;
    private String tenantId;

    public ActDeployment() {
    }

    public ActDeployment(Deployment deployment) {
        this.id = deployment.getId();
        this.name = deployment.getName();
        this.deploymentTime = deployment.getDeploymentTime();
        this.category = deployment.getCategory();
        this.tenantId = deployment.getTenantId();
    }
}
