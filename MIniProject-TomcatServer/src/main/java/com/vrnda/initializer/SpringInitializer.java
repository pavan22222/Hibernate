package com.vrnda.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.vrnda.cfgs.SpringConfiguration;

public class SpringInitializer implements WebApplicationInitializer {
	 @Override
	    public void onStartup(ServletContext container) {
		 AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
	        context.register(SpringConfiguration.class);
	        ServletRegistration.Dynamic dispatcher = container
	          .addServlet("dispatcher", new DispatcherServlet(context));

	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	    }

	
}
