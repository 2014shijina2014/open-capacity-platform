package com.open.capacity.security.model.ext;

import java.util.List;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 下拉树形菜单
 **/
public class TreeSelect {
    private Long id;
    private String name;
    private List<TreeSelect> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<TreeSelect> children) {
        this.children = children;
    }
}
