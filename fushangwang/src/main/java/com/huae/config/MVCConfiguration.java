package com.huae.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MVCConfiguration extends WebMvcConfigurerAdapter{
	  @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	 
	        registry.addViewController("/").setViewName("forward:/index.html");
	 
	        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	 
	        super.addViewControllers(registry);
	 
	    }
}
