package com.open.capacity.security.service;

import com.alibaba.fastjson.JSONObject;
import com.open.capacity.security.dao.OauthClientDetailsDao;
import com.open.capacity.security.dto.OauthClientDetailsDto;
import com.open.capacity.security.model.OauthClientDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 客户模式的客户端APP管理逻辑
 * @author caoheyang
 * @version 20180730
 */
@Service
public class OauthClientService {

    private static final Logger log = LoggerFactory.getLogger(OauthClientService.class);

    //缓存client的redis key，这里是hash结构存储
    private static final String CACHE_CLIENT_KEY = "oauth_client_details";

    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 操作客户端app
     * @param clientDto 业务实体
     */
    @Transactional
    public void saveClient(OauthClientDetailsDto clientDto) {
        OauthClientDetails client = clientDto;
        List<Long> permissionIds = clientDto.getPermissionIds();
        permissionIds.remove(0L);

        //存在则新增，不存在则修改
        if (client.getId() != null) {// 修改
            updateClient(client, permissionIds);
        } else { // 新增
            saveClient(client, permissionIds);
        }
    }

    /**
     *  新增逻辑
     * @param client
     * @param permissionIds
     */
    private void saveClient(OauthClientDetails client, List<Long> permissionIds) {
        OauthClientDetails r = oauthClientDetailsDao.getClient(client.getClientId());
        if (r != null) {
            throw new IllegalArgumentException(client.getClientId() + "已存在");
        }

        oauthClientDetailsDao.save(client);
        if (!CollectionUtils.isEmpty(permissionIds)) {
            oauthClientDetailsDao.saveClientPermission(client.getId(), permissionIds);
        }
        log.debug("新增应用{}", client.getClientId());
    }

    /**
     * 修改逻辑
     * @param client
     * @param permissionIds
     */
    private void updateClient(OauthClientDetails client, List<Long> permissionIds) {
        oauthClientDetailsDao.update(client);
        oauthClientDetailsDao.deleteClientPermission(client.getId());

        if (!CollectionUtils.isEmpty(permissionIds)) {
            oauthClientDetailsDao.saveClientPermission(client.getId(), permissionIds);//app的api权限
        }

        String clientId = oauthClientDetailsDao.getById(client.getId()).getClientId();
        BaseClientDetails clientDetails = null;

        try {
            String value = (String) redisTemplate.boundHashOps(CACHE_CLIENT_KEY).get(clientId);   // 先从redis获取
            clientDetails = JSONObject.parseObject(value, BaseClientDetails.class);
            clientDetails.setClientSecret(client.getClientSecret());
            redisTemplate.boundHashOps(CACHE_CLIENT_KEY).put(clientId, JSONObject.toJSONString(clientDetails)); //更新redis里的clint信息
        } catch (Exception e) {

        }
        log.debug("修改应用{}", client.getClientId());
    }

    /**
     * 删除
     * @param id 应用id
     */
    @Transactional
    public void deleteClient(Long id) {
        oauthClientDetailsDao.deleteClientPermission(id);
        oauthClientDetailsDao.delete(id);
        log.debug("删除应用id:{}", id);
    }
}
