package com.open.capacity.client.oauth2.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 配置类 网关整合
 *
 * @author caoheyang
 * @date 20180725
 */
@Primary
@Component
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
//      zuul routes  /client/ zuul 集中管理api文档
//      分布式文档集成  
        resources.add(swaggerResource("认证中心", "/auth/v2/api-docs", "2.0"));
        resources.add(swaggerResource("erukea客户端", "/client/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}