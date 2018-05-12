package com.open.capacity.security.utils;

import com.open.capacity.security.model.Permission;
import com.open.capacity.security.model.Role;
import com.open.capacity.security.model.ext.TreeSelect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 下拉树形菜单
 **/
@Component
public class TreeSelectUtil {

        public List<TreeSelect> MenuSelectTree(List<Permission> menu){
            List<TreeSelect> list = new ArrayList<>();
            for (Permission x : menu) {
                TreeSelect ts = new TreeSelect();
                if("-1".equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(MenuSelectChild(menu,x.getId()));
                    list.add(ts);
                }
            }
            Collections.reverse(list);
            return list;
        }

        public  List<TreeSelect> MenuSelectChild(List<Permission> menu,Long id){
            List<TreeSelect> lists = new ArrayList<TreeSelect>();
            for(Permission x:menu){
                TreeSelect ts = new TreeSelect();
                if(id.equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(MenuSelectChild(menu,x.getId()));
                    lists.add(ts);
                }
            }
            return lists;

        }

        /*public List<TreeSelect> RoleSelectTree(List<Role> role){
            List<TreeSelect> list = new ArrayList<>();
            for (Role x : role) {
                TreeSelect ts = new TreeSelect();
                if("-1".equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(RoleSelectChild(role,x.getId()));
                    list.add(ts);
                }
            }
            Collections.reverse(list);
            return list;
        }

        public  List<TreeSelect> RoleSelectChild(List<Role> role,String id){
            List<TreeSelect> lists = new ArrayList<TreeSelect>();
            for(Role x:role){
                TreeSelect ts = new TreeSelect();
                if(id.equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(RoleSelectChild(role,x.getId()));
                    lists.add(ts);
                }
            }
            return lists;

        }*/


}
