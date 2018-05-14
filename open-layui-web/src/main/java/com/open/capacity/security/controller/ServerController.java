package com.open.capacity.security.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.PermissionDao;
import com.open.capacity.security.dao.ServerDao;
import com.open.capacity.security.dto.LoginUser;
import com.open.capacity.security.model.Permission;
import com.open.capacity.security.model.SysServer;
import com.open.capacity.security.service.PermissionService;
import com.open.capacity.security.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wjh
 * @create 2018-05-07 11:53
 * @desc 服务管理
 **/
@Api(tags = "服务管理")
@RestController
@RequestMapping("/sys/server")
public class ServerController {
	@Autowired
     private ServerDao serverDao;
	/**
	 * 服务列表
	 * 
	 * @param pId
	 * @param serversAll
	 * @param list
	 */
	private void setServerList(Long pId, List<SysServer> serversAll, List<SysServer> list) {
		for (SysServer per : serversAll) {
			if (per.getParentId().equals(pId)) {
				list.add(per);
				if (serversAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
					setServerList(per.getId(), serversAll, list);
				}
			}
		}
	}

	/**
	 * 根据模块ID获取服务列表
	 * @return
	 */
	@PostMapping("/list")
	@ApiOperation(value = "根据模块ID获取服务列表")
	@PreAuthorize("hasAuthority('sys:server:query')")
	public List<SysServer> serversList(Long moduleId) {
		List<SysServer> serversAll = serverDao.listAll(moduleId);

		List<SysServer> list = Lists.newArrayList();
		setServerList(0L, serversAll, list);

		return list;
	}

	@PostMapping("/all")
	@ApiOperation(value = "根据模块ID获取所有服务")
	@PreAuthorize("hasAuthority('sys:server:query')")
	public JSONArray serversAll(Long moduleId) {
		List<SysServer> serversAll = serverDao.listAll(moduleId);
		JSONArray array = new JSONArray();
		setServersTree(0L, serversAll, array);

		return array;
	}

	/**
	 * 服务树
	 * 
	 * @param pId
	 * @param serversAll
	 * @param array
	 */
	private void setServersTree(Long pId, List<SysServer> serversAll, JSONArray array) {
		for (SysServer per : serversAll) {
			if (per.getParentId().equals(pId)) {
				String string = JSONObject.toJSONString(per);
				JSONObject parent = (JSONObject) JSONObject.parse(string);
				array.add(parent);

				if (serversAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
					JSONArray child = new JSONArray();
					parent.put("child", child);
					setServersTree(per.getId(), serversAll, child);
				}
			}
		}
	}

	@LogAnnotation
	@PostMapping
	@ApiOperation(value = "保存服务")
	@PreAuthorize("hasAuthority('sys:server:add')")
	public void save(@RequestBody SysServer sysServer) {
		serverDao.save(sysServer);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据服务id获取服务")
	@PreAuthorize("hasAuthority('sys:server:query')")
	public SysServer get(@PathVariable Long id) {
		return serverDao.getById(id);
	}

	@LogAnnotation
	@PutMapping
	@ApiOperation(value = "修改服务")
	@PreAuthorize("hasAuthority('sys:server:add')")
	public void update(@RequestBody SysServer sysServer) {
		serverDao.update(sysServer);
	}

	@LogAnnotation
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除服务")
	@PreAuthorize("hasAuthority('sys:server:del')")
	public void delete(@PathVariable Long id) {
		serverDao.delete(id);
	}
}
