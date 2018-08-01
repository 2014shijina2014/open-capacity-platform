package com.open.capacity.security.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 中台登陆用户
 *
 * @DBTable sys_userl
 */
public class SysUser extends BaseEntity<Long> {

    private static final long serialVersionUID = -6525908145032868837L;

    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickname;
    //头像地址
    private String headImgUrl;
    //电话
    private String phone;
    //手机号
    private String telephone;
    //邮箱
    private String email;
    //生日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //性别
    private Integer sex;
    //状态  不可用:0   有效:1  锁定:2
    private Integer status;
    //TODO
    private String intro;

    /**
     * 用户名
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 昵称
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 头像地址
     *
     * @return
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 头像地址
     *
     * @param headImgUrl
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    /**
     * 电话
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 手机号
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机号
     *
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 邮箱
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 生日
     *
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 性别
     *
     * @return
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 状态  不可用:0   有效:1  锁定:2
     *
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态  不可用:0   有效:1  锁定:2
     *
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public interface Status {
        int DISABLED = 0;
        int VALID = 1;
        int LOCKED = 2;
    }

}
