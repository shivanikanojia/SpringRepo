package com.shivani.srk.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@Configuration
@ComponentScan ("com.shivani.srk.controller")

@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

	//	 public void onStartup(ServletContext container) {
	//	        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
	//	        appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
	//
	//	        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
	//	        registration.setLoadOnStartup(1);
	//	        registration.addMapping("/");
	//	    }	
	//	
	//	@Bean
	//	public InternalResourceViewResolver viewResolver() {
	//		InternalResourceViewResolver vr = new InternalResourceViewResolver();
	//		vr.setPrefix("/");
	//		vr.setSuffix(".jsp");
	//		return vr;
	//	} 

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.freeMarker();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/**")
		.addResourceLocations("/");
	}
	@Bean 
	public FreeMarkerConfigurer freemarkerConfig() { 
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
		freeMarkerConfigurer.setTemplateLoaderPath("/");
		return freeMarkerConfigurer; 
	}	

}
