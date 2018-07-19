package com.open.capacity.security.dto;

import com.open.capacity.security.model.Notice;
import com.open.capacity.security.model.SysUser;

import java.io.Serializable;
import java.util.List;

public class NoticeVO implements Serializable {

    private static final long serialVersionUID = 7363353918096951799L;

    private Notice notice;

    private List<SysUser> users;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

}
