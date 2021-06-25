/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import thiendz.j5.assignment.filter.InterceptorAdmin;
import thiendz.j5.assignment.filter.InterceptorAll;
import thiendz.j5.assignment.filter.InterceptorGuest;
import thiendz.j5.assignment.filter.InterceptorUser;

@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {

	@Autowired
	InterceptorUser interceptorUser;
	@Autowired
	InterceptorAdmin interceptorAdmin;
	@Autowired
	InterceptorGuest interceptorGuest;
	@Autowired
	InterceptorAll interceptorAll;

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(interceptorAdmin).addPathPatterns("/admin/*");
		interceptorRegistry.addInterceptor(interceptorUser).addPathPatterns("/list-order", "/payment", "/logout",
				"/account");
		interceptorRegistry.addInterceptor(interceptorGuest).addPathPatterns("/login", "/register");
		interceptorRegistry.addInterceptor(interceptorAll).addPathPatterns("/**");
	}

}
