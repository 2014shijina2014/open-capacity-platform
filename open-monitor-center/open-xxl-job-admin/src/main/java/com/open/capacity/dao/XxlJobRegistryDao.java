package com.open.capacity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.open.capacity.core.model.XxlJobRegistry;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface XxlJobRegistryDao {

    public int removeDead(@Param("timeout") int timeout);

    public List<XxlJobRegistry> findAll(@Param("timeout") int timeout);

    public int registryUpdate(@Param("registryGroup") String registryGroup,
                              @Param("registryKey") String registryKey,
                              @Param("registryValue") String registryValue);

    public int registrySave(@Param("registryGroup") String registryGroup,
                            @Param("registryKey") String registryKey,
                            @Param("registryValue") String registryValue);

    public int registryDelete(@Param("registryGroup") String registGroup,
                          @Param("registryKey") String registryKey,
                          @Param("registryValue") String registryValue);

}
