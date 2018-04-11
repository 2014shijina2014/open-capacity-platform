package com.ctrip.framework.apollo.common.controller;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    PageableHandlerMethodArgumentResolver pageResolver =
            new PageableHandlerMethodArgumentResolver();
    pageResolver.setFallbackPageable(new PageRequest(0, 10));

    argumentResolvers.add(pageResolver);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false);
    configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.APPLICATION_JSON);
  }

  @Override
  public void customize(ConfigurableEmbeddedServletContainer container) {
    MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
    mappings.add("html", "text/html;charset=utf-8");
    container.setMimeMappings(mappings );
  }
}
