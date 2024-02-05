package org.globant.httpinterceptorsexample.springinterceptors;

import org.globant.httpinterceptorsexample.springinterceptors.interceptors.LoginSessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("timeinterceptor")
    private HandlerInterceptor timeInterceptor;

    @Autowired
    @Qualifier("loginInterceptor")
    private LoginSessionInterceptor loginInterceptor;

    @SuppressWarnings("null")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/find/all");
    }
}
