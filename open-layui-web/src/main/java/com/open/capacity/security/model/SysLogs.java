package com.open.capacity.security.model;

/**
 * 中台操作日志表
 *
 * @DBTable sys_logs
 */
public class SysLogs extends BaseEntity<Long> {

    private static final long serialVersionUID = -7809315432127036583L;
    //中台登陆用户
    private SysUser user;
    //模块名
    private String module;
    //成功失败
    private Boolean flag;
    //备注
    private String remark;

    /**
     * 中台登陆用户
     *
     * @return
     */
    public SysUser getUser() {
        return user;
    }

    /**
     * 中台登陆用户
     *
     * @param user
     */
    public void setUser(SysUser user) {
        this.user = user;
    }

    /**
     * 模块名
     *
     * @return
     */
    public String getModule() {
        return module;
    }

    /**
     * 模块名
     *
     * @param module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 成功失败
     *
     * @return
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 成功失败
     *
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 备注
     *
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
