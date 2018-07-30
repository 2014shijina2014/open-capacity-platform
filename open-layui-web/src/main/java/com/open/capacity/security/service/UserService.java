package com.open.capacity.security.service;

import com.open.capacity.security.dao.SysUserDao;
import com.open.capacity.security.dto.SysUserDto;
import com.open.capacity.security.model.SysUser;
import com.open.capacity.security.model.SysUser.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 新增保存用户
     *
     * @param userDto
     * @return
     */
    @Transactional
    public SysUser saveUser(SysUserDto userDto) {
        SysUser user = userDto;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.VALID);
        sysUserDao.save(user);
        saveUserRoles(user.getId(), userDto.getRoleIds());

        log.debug("新增用户{}", user.getUsername());
        return user;
    }

    private void saveUserRoles(Long userId, List<Long> roleIds) {
        if (roleIds != null) {
            sysUserDao.deleteUserRole(userId);
            if (!CollectionUtils.isEmpty(roleIds)) {
                sysUserDao.saveUserRoles(userId, roleIds);
            }
        }
    }


    public SysUser getUser(String username) {
        return sysUserDao.getUser(username);
    }


    public void changePassword(String username, String oldPassword, String newPassword) {
        SysUser u = sysUserDao.getUser(username);
        if (u == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (!passwordEncoder.matches(oldPassword, u.getPassword())) {
            throw new IllegalArgumentException("旧密码错误");
        }

        sysUserDao.changePassword(u.getId(), passwordEncoder.encode(newPassword));

        log.debug("修改{}的密码", username);
    }

    @Transactional
    public SysUser updateUser(SysUserDto userDto) {
        sysUserDao.update(userDto);
        saveUserRoles(userDto.getId(), userDto.getRoleIds());
        return userDto;
    }

}
