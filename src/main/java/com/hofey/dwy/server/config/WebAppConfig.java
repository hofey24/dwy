package com.hofey.dwy.server.config;

import com.hofey.dwy.server.intercepter.AllowCrossDomainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: hofey
 * @Date: 2020/1/7 17:15
 * @Description: web 应用配置类
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {


    @Bean
    protected AllowCrossDomainInterceptor getDomainInterceptor(){
        return new AllowCrossDomainInterceptor();
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(getDomainInterceptor()).addPathPatterns("/");
    }
}
