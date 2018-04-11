package com.open.capacity.security.service;

import com.open.capacity.security.dto.UserDto;
import com.open.capacity.security.model.SysUser;

public interface UserService {

	SysUser saveUser(UserDto userDto);

	SysUser updateUser(UserDto userDto);

	SysUser getUser(String username);

	void changePassword(String username, String oldPassword, String newPassword);

}
