package com.hofey.dwy.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: hofey
 * @Date: 2020/1/8 17:36
 * @Description:
 */
@Configuration
@ComponentScan(value = "com.hofey.dwy")
@EnableAspectJAutoProxy//开启aspect代理注解
public class AopConfig {
}
