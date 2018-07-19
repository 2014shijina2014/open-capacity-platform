package com.open.capacity.fegin;

import com.open.capacity.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: [gitgeek]
 * @Date: [2018-07-19 17:48]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@FeignClient(value = "open-user-center", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/users/current")
    Object currentUser();

    @GetMapping("/users/internal")
    Object findByUsername(@RequestParam("username") String username);


}
