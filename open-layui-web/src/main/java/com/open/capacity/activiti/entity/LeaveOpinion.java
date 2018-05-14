package com.open.capacity.activiti.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:22]
 * @Description: [ 请假流程 审批信息 ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Getter
@Setter
public class LeaveOpinion  implements Serializable {

    //审批人id
    private String opId;
    //审批人姓名
    private String opName;
    //审批意见
    private String opinion;
    //审批时间
    private Date createTime;
    //是否通过
    private boolean flag;
    //流程id
    private String taskId;

}