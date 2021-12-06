package com.simplilearn.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class WebAppInitializer  implements WebApplicationInitializer {
	
	
	
	 @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	        appContext.register(ApplicationContextConfig.class);
	        
	       // appContext.setServletContext(servletContext);
	        
	        ContextLoaderListener loaderListener = new ContextLoaderListener(appContext);
	        servletContext.addListener(loaderListener);
	         
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
	                "dispatcher", new DispatcherServlet(appContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	      
	 }
}
