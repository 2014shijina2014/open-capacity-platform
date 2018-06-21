package com.open.capacity.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.open.capacity.security.annotation.LogAnnotation;
import com.open.capacity.security.dao.ClientDao;
import com.open.capacity.security.dto.ClientDto;
import com.open.capacity.security.model.Client;
import com.open.capacity.security.page.table.PageTableHandler;
import com.open.capacity.security.page.table.PageTableHandler.CountHandler;
import com.open.capacity.security.page.table.PageTableHandler.ListHandler;
import com.open.capacity.security.page.table.PageTableRequest;
import com.open.capacity.security.page.table.PageTableResponse;
import com.open.capacity.security.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色相关接口
 * 
 * @author owen 624191343@qq.com
 *
 */
@Api(tags = "应用")
@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientDao clientDao;

	@LogAnnotation
	@PostMapping
	@ApiOperation(value = "保存角色")
	@PreAuthorize("hasAuthority('sys:role:add')")
	public void saveRole(@RequestBody ClientDto clientDto) {
		clientService.saveClient(clientDto);
	}

	@GetMapping
	@ApiOperation(value = "角色列表")
	@PreAuthorize("hasAuthority('sys:role:query')")
	public PageTableResponse listRoles(PageTableRequest request) {
		return new PageTableHandler(new CountHandler() {

			@Override
			public int count(PageTableRequest request) {
				return clientDao.count(request.getParams());
			}
		}, new ListHandler() {

			@Override
			public List<Client> list(PageTableRequest request) {
				List<Client> list = clientDao.list(request.getParams(), request.getOffset(), request.getLimit());
				return list;
			}
		}).handle(request);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取角色")
	@PreAuthorize("hasAuthority('sys:role:query')")
	public Client get(@PathVariable Long id) {
		return clientDao.getById(id);
	}

	@GetMapping("/all")
	@ApiOperation(value = "所有角色")
	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
	public List<Client> roles() {
		return clientDao.list(Maps.newHashMap(), null, null);
	}

	@GetMapping(params = "userId")
	@ApiOperation(value = "根据用户id获取拥有的角色")
	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
	public List<Client> roles(Long userId) {
		return clientDao.listByUserId(userId);
	}

	@LogAnnotation
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除角色")
	@PreAuthorize("hasAuthority('sys:role:del')")
	public void delete(@PathVariable Long id) {
		clientService.deleteClient(id);
	}
}
