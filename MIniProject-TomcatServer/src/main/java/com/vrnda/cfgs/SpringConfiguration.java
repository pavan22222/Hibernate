package com.vrnda.cfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.vrnda")
public class SpringConfiguration {
	
	@Bean
	public InternalResourceViewResolver createResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/Pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
