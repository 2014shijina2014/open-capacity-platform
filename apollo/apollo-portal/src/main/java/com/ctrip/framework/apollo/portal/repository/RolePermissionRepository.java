package com.ctrip.framework.apollo.portal.repository;

import com.ctrip.framework.apollo.portal.entity.po.RolePermission;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface RolePermissionRepository extends PagingAndSortingRepository<RolePermission, Long> {

  /**
   * find role permissions by role ids
   */
  List<RolePermission> findByRoleIdIn(Collection<Long> roleId);

}
