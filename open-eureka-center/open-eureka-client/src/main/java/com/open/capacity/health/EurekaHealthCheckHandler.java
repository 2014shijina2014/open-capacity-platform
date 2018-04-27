package com.open.capacity.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

@Component
public class EurekaHealthCheckHandler implements HealthCheckHandler {

	@Autowired
	private EurekaClientHealthIndicator halthIndicator;
	
	public InstanceStatus getStatus(InstanceStatus currentStatus) {
		Status status = halthIndicator.health().getStatus();
		if(status.equals(Status.UP)) {
			return InstanceStatus.UP;
		} else {
			return InstanceStatus.DOWN;
		}
	}

}
