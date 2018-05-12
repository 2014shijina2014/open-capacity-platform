package com.open.capacity.security.utils;

import com.open.capacity.security.model.Permission;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 下拉树形菜单
 **/
@Component
public  class MenuTreeUtil {

    public  List<Permission> menuList(List<Permission> menu){
        List<Permission> list = new ArrayList<>();
        for (Permission x : menu) {
            Permission sysMenu = new Permission();
            if("-1".equals(x.getParentId())){
                sysMenu.setId(x.getId());
                sysMenu.setModuleId(x.getModuleId());
                sysMenu.setName(x.getName());
                sysMenu.setParentId(x.getParentId());
                sysMenu.setCss(x.getCss());
                sysMenu.setSort(x.getSort());
                sysMenu.setType(x.getType());
                sysMenu.setPermission(x.getPermission());
                sysMenu.setHref(x.getHref());
                sysMenu.setChild(menuChild(menu,x.getId()));
                list.add(sysMenu);
            }
        }
        return list;
    }

    public  List<Permission> menuChild(List<Permission> menu,Long id){
        List<Permission> lists = new ArrayList<Permission>();
        for(Permission x:menu){
            Permission sysMenu = new Permission();
            if(id.equals(x.getParentId())){
                sysMenu.setId(x.getId());
                sysMenu.setModuleId(x.getModuleId());
                sysMenu.setName(x.getName());
                sysMenu.setParentId(x.getParentId());
                sysMenu.setCss(x.getCss());
                sysMenu.setSort(x.getSort());
                sysMenu.setType(x.getType());
                sysMenu.setPermission(x.getPermission());
                sysMenu.setHref(x.getHref());
                sysMenu.setChild(menuChild(menu,x.getId()));
                lists.add(sysMenu);
            }
        }
        return lists;

    }
}
