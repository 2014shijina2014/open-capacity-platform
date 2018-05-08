package com.open.capacity.server.oauth2.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableWebMvc
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	 
	@Bean
	public Docket createRestApi() {
		
		
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("Authorization").description("令牌").
		modelRef(new ModelRef("string")).
		parameterType("header").required(false).build();
		
		
		ParameterBuilder clientPar = new ParameterBuilder();
		clientPar.name("client_id").description("应用ID").
		modelRef(new ModelRef("string")).
		parameterType("header").required(false).build();
		
		ParameterBuilder secretPar = new ParameterBuilder();
		secretPar.name("client_secret").description("应用密钥").
		modelRef(new ModelRef("string")).
		parameterType("header").required(false).build();
		
		pars.add(tokenPar.build());
		pars.add(clientPar.build()); 
		pars.add(secretPar.build()); 
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// .apis(RequestHandlerSelectors.basePackage("com.open.capacity"))
				.apis(RequestHandlerSelectors.any())
				.paths( input ->PathSelectors.regex("/user.*").apply(input) || PathSelectors.regex("/client.*").apply(input) )
				// .paths(PathSelectors.any())
				.build().globalOperationParameters(pars);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("认证中心api").description("认证中心api").version("1.0").build();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/");
		resolver.setSuffix(".html");
		return resolver;

	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}