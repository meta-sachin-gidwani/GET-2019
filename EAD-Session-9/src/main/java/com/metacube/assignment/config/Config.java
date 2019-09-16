package com.metacube.assignment.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.assignment.filter.MyFilter;

@Configuration
public class Config {

	@Bean
	public FilterRegistrationBean<MyFilter> validationFilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/homePage","/friendList","/imageChange","/imageUpload","/friendProfile","/update","/logout");
		return registrationBean;
	}
}
