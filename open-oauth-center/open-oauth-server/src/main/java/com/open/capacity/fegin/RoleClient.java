package com.open.capacity.fegin;

import com.open.capacity.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Author: [gitgeek]
 * @Date: [2018-07-19 17:47]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@FeignClient(value = "open-user-center", configuration = FeignConfig.class)
public interface RoleClient {
}
