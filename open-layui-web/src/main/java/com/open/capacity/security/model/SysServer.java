package com.open.capacity.security.model;

import java.util.List;
/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 服务管理
 **/
public class SysServer extends BaseEntity<Long> {

	private static final long serialVersionUID = 6180869216498363919L;
	private Long moduleId;
	private String moduleName;
	private Long parentId;
	private String name;
	private String path;
	private String description;
	private Integer sort;
	private List<SysServer> child;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<SysServer> getChild() {
		return child;
	}

	public void setChild(List<SysServer> child) {
		this.child = child;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
