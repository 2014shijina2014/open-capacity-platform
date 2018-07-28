package com.open.capacity.security.controller;

import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.SysUserDao;
import com.open.capacity.security.dto.SysUserDto;
import com.open.capacity.security.model.SysUser;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.UserService;
import com.open.capacity.security.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户相关接口
 *
 * @author 624191343@qq.com
 */
@Api(tags = "中台用户相关接口")
@RestController
@RequestMapping("/users")
public class SysUserController {

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 保存用户
     *
     * @param userDto 用户
     * @return
     */
    @LogAnnotation
    @PostMapping
    @ApiOperation(value = "保存用户")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public SysUser saveUser(@RequestBody SysUserDto userDto) {
        SysUser u = userService.getUser(userDto.getUsername());
        if (u != null) {
            throw new IllegalArgumentException(userDto.getUsername() + "已存在");
        }
        return userService.saveUser(userDto);
    }

    /**
     * 修改用户
     *
     * @param userDto 用户
     * @return
     */
    @LogAnnotation
    @PutMapping
    @ApiOperation(value = "修改用户")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public SysUser updateUser(@RequestBody SysUserDto userDto) {
        return userService.updateUser(userDto);
    }

    /**
     * 修改头像
     *
     * @param headImgUrl 头像
     */
    @LogAnnotation
    @PutMapping(params = "headImgUrl")
    @ApiOperation(value = "修改头像")
    public void updateHeadImgUrl(String headImgUrl) {
        SysUser user = UserUtil.getLoginUser();
        SysUserDto userDto = new SysUserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setHeadImgUrl(headImgUrl);
        userService.updateUser(userDto);
        log.debug("{}修改了头像", user.getUsername());
    }

    /**
     * 修改密码
     *
     * @param username    用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    @LogAnnotation
    @PutMapping("/{username}")
    @ApiOperation(value = "修改密码")
    @PreAuthorize("hasAuthority('sys:user:password')")
    public void changePassword(@PathVariable String username, String oldPassword, String newPassword) {
        userService.changePassword(username, oldPassword, newPassword);
    }

    /**
     * 用户列表
     *
     * @param request 用户分页数据体
     * @return
     */
    @GetMapping
    @ApiOperation(value = "用户列表")
    @PreAuthorize("hasAuthority('sys:user:query')")
    public PageTableResponse listUsers(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {
            @Override
            public int count(PageTableRequest request) {
                return sysUserDao.count(request.getParams());
            }
        }, new ListHandler() {
            @Override
            public List<SysUser> list(PageTableRequest request) {
                List<SysUser> list = sysUserDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return list;
            }
        }).handle(request);
    }

    /**
     * 当前登录用户
     *
     * @return
     */
    @ApiOperation(value = "当前登录用户")
    @GetMapping("/current")
    public SysUser currentUser() {
        return UserUtil.getLoginUser();
    }

    /**
     * 根据用户id获取用户
     *
     * @param id 用户id
     * @return
     */
    @ApiOperation(value = "根据用户id获取用户")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('sys:user:query')")
    public SysUser user(@PathVariable Long id) {
        return sysUserDao.getById(id);
    }

}
