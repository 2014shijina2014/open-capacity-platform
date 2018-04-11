package com.open.capacity.security.model;

public class SysLogs extends BaseEntity<Long> {

	private static final long serialVersionUID = -7809315432127036583L;
	private SysUser user;
	private String module;
	private Boolean flag;
	private String remark;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
