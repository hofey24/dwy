package com.hofey.dwy.server.config;

import com.hofey.dwy.server.intercepter.AllowCrossDomainInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: hofey
 * @Date: 2020/1/7 17:15
 * @Description:
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {
    @Autowired
    private AllowCrossDomainInterceptor domainInterceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(domainInterceptor).addPathPatterns("/");
    }
}
