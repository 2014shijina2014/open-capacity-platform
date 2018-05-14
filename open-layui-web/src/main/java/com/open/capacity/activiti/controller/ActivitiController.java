package com.open.capacity.activiti.controller;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 19:06]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Controller
@RequestMapping(value = "/act")
public class ActivitiController {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    IdentityService identityService;

    /**
     * 部署列表
     */
    @GetMapping(value = "showAct")
    @ResponseBody
    public String showAct(org.springframework.ui.Model model, ProcessDefinition definition,
                          String page, String limit){
        ProcessDefinitionQuery processDefinitionQuery = repositoryService
                .createProcessDefinitionQuery();

        List<ProcessDefinition> processDefinitionList = null;
        if (definition != null) {
            if (!StringUtils.isEmpty(definition.getDeploymentId())) {
                processDefinitionQuery.deploymentId(definition.getDeploymentId());
            }
            if (!StringUtils.isEmpty(definition.getName())) {
                processDefinitionQuery.processDefinitionNameLike("%" + definition.getName() + "%");

            }
        }
        processDefinitionList = processDefinitionQuery.listPage(Integer.valueOf(limit) * (Integer.valueOf(page) - 1), Integer.valueOf(limit));
        long count = repositoryService.createDeploymentQuery().count();
        List<ProcessDefinition> list = new ArrayList<>();


//        ReType reType = new ReType(count, list);
        return null;
    }





}
