package com.callcenter1.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import com.callcenter1.Callcenter1Application;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
      //  return new Class[] { AppConfig.class };
    	  return new Class[] { Callcenter1Application.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
