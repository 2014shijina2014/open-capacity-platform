package com.open.capacity.security.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.open.capacity.security.dao.ClientDao;
import com.open.capacity.security.dto.ClientDto;
import com.open.capacity.security.model.Client;
import com.open.capacity.security.model.Role;
import com.open.capacity.security.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientDao clientDao;

	@Override
	@Transactional
	public void saveClient(ClientDto roleDto) {
		Client role = roleDto;
		List<Long> permissionIds = roleDto.getPermissionIds();
		permissionIds.remove(0L);

		if (role.getId() != null) {// 修改
			updateRole(role, permissionIds);
		} else {// 新增
			saveRole(role, permissionIds);
		}
	}

	private void saveRole(Client client, List<Long> permissionIds) {
		Client r = clientDao.getClient(client.getClientId());
		if (r != null) {
			throw new IllegalArgumentException(client.getClientId() + "已存在");
		}

		clientDao.save(client);
		if (!CollectionUtils.isEmpty(permissionIds)) {
			clientDao.saveClientPermission(client.getId(), permissionIds);
		}
		log.debug("新增应用{}", client.getClientId());
	}

	private void updateRole(Client client, List<Long> permissionIds) {
		Client r = clientDao.getClient(client.getClientId());
		if (r != null && r.getId() != client.getId()) {
			throw new IllegalArgumentException(client.getClientId() + "已存在");
		}

		clientDao.update(client);

		clientDao.deleteClientPermission(client.getId());
		if (!CollectionUtils.isEmpty(permissionIds)) {
			clientDao.saveClientPermission(client.getId(), permissionIds);
		}
		log.debug("修改应用{}", client.getClientId());
	}

	@Override
	@Transactional
	public void deleteClient(Long id) {
		clientDao.deleteClientPermission(id);
		clientDao.delete(id);

		log.debug("删除应用id:{}", id);
	}

}
