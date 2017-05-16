package com.eventzone.cosc412.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
//	
//	@Bean
//	public DandelionDialect dandelionDialect()
//	{
//			return new DandelionDialect();
//	}
//
//	@Bean
//	public DataTablesDialect dataTablesDialect()
//	{
//			return new DataTablesDialect();
//	}
//
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean()
//	{
//			FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//			filterRegistrationBean.setFilter(new DandelionFilter());
//			return filterRegistrationBean;
//	}
//
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean()
//	{
//			ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//			servletRegistrationBean.setServlet(new DandelionServlet());
//			servletRegistrationBean.addUrlMappings("/dandelion-assets/*");
//			servletRegistrationBean.setName("dandelionServlet");
//			return servletRegistrationBean;
//	}

}