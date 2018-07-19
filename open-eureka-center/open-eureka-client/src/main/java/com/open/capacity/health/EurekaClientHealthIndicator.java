package com.open.capacity.health;

import com.open.capacity.controller.EurekaManageController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class EurekaClientHealthIndicator implements HealthIndicator {


    public Health health() {
        if (EurekaManageController.upOrDown) {
            return new Health.Builder(Status.UP).withDetail("details", "").withDetail("status", Status.UP).build();
        } else {
            return new Health.Builder(Status.DOWN).withDetail("details", "").withDetail("status", Status.DOWN).build();
        }
    }

}  