package com.open.capacity.activiti.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-14 20:23]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Configuration
@PropertySource("classpath:activiti.properties")
public class ActPropertiesConfig {
    @Value("${modelId}")
    private String modelId;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Bean
    public ActPropertiesConfig getActPropertiesConfig(){
        return new ActPropertiesConfig();
    }
}
