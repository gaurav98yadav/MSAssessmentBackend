package com.accoflow.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static final Class<?>[] NO_FILES = null;

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	
    	return NO_FILES;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
