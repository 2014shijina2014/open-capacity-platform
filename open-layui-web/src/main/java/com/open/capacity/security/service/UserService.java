package com.open.capacity.security.service;

import com.open.capacity.security.dto.SysUserDto;
import com.open.capacity.security.model.SysUser;

public interface UserService {

    SysUser saveUser(SysUserDto userDto);

    SysUser updateUser(SysUserDto userDto);

    SysUser getUser(String username);

    void changePassword(String username, String oldPassword, String newPassword);

}
