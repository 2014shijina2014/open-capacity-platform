package com.open.capacity.controller;

import com.open.capacity.fegin.PermissionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: [gitgeek]
 * @Date: [2018-07-12 17:01]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionClient permissionClient;

    @GetMapping("/current")
    public Object permissionsCurrent(){
        return permissionClient.permissionsCurrent();
    }

    @GetMapping("/all")
    public Object permissionsAll(){
        return permissionClient.permissionsAll();
    }

    @GetMapping("/parents")
    public Object parents(){
        return permissionClient.parentMenu();
    }




}
