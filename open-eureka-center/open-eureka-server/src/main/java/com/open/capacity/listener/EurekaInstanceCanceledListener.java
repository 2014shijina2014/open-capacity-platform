package com.open.capacity.listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 用于监听eureka服务停机通知
 */
@Configuration
public class EurekaInstanceCanceledListener implements ApplicationListener {
    private Logger log = LoggerFactory.getLogger(EurekaInstanceCanceledListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 服务挂掉事件
        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            // 获取当前Eureka实例中的节点信息
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            // 遍历获取已注册节点中与当前失效节点ID一致的节点信息
            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {
                    if (instance.getInstanceId().equals(event.getServerId())) {
                        log.debug("服务：" + instance.getAppName() + " 挂啦。。。");
                        // // TODO: 2017/9/3 扩展消息提醒 邮件、手机短信、微信等
                    }
                });
            });
        }
        if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
            EurekaInstanceRegisteredEvent event = (EurekaInstanceRegisteredEvent) applicationEvent;
            log.debug("服务：" + event.getInstanceInfo().getAppName() + " 注册成功啦。。。");
        }
        if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
            EurekaInstanceRenewedEvent event = (EurekaInstanceRenewedEvent) applicationEvent;
            log.debug("心跳检测服务：" + event.getInstanceInfo().getAppName() + "。。");
        }
        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
            log.debug("服务 Aualiable。。");
        }

    }
}

