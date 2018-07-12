package com.open.capacity.fegin;

import com.alibaba.fastjson.JSONArray;
import com.open.capacity.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: [gitgeek]
 * @Date: [2018-07-12 10:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@FeignClient(value = "open-user-center",configuration = FeignConfig.class)
public interface PermissionClient {


    @RequestMapping(value = "/permissions/current",method = RequestMethod.GET)
    List permissionsCurrent();

    @RequestMapping(value = "/permissions/all",method = RequestMethod.GET)
    JSONArray permissionsAll();

    @RequestMapping(value = "/permissions/parents",method = RequestMethod.GET)
    List parentMenu();


}
