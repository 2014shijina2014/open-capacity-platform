package com.open.capacity.security.model;

import java.util.List;

/**
 * 中台资源权限表
 *
 * @DBTable sys_permission
 */
public class SysPermission extends BaseEntity<Long> {

    private static final long serialVersionUID = 6180869216498363919L;
    //父权限ID
    private Long parentId;
    //权限名称
    private String name;
    //样式
    private String css;
    //链接
    private String href;
    //资源类型 1菜单 2按钮
    private Integer type;
    //权限标识符
    private String permission;
    //排序号
    private Integer sort;

    //子资源
    private List<SysPermission> child;

    /**
     * 父权限ID
     *
     * @return
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父权限ID
     *
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 权限名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 权限名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 样式
     *
     * @return
     */
    public String getCss() {
        return css;
    }

    /**
     * 样式
     *
     * @param css
     */
    public void setCss(String css) {
        this.css = css;
    }

    /**
     * 链接
     *
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * 链接
     *
     * @param href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 资源类型 1菜单 2按钮
     *
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 资源类型 1菜单 2按钮
     *
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 权限标识符
     *
     * @return
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 权限标识符
     *
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 排序号
     *
     * @return
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序号
     *
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 子资源
     *
     * @return
     */
    public List<SysPermission> getChild() {
        return child;
    }

    /**
     * 子资源
     *
     * @param child
     */
    public void setChild(List<SysPermission> child) {
        this.child = child;
    }
}
