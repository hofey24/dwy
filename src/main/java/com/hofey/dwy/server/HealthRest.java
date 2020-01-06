package com.hofey.dwy.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hofey
 * @Date: 2020/1/6 16:06
 * @Description:
 */
@RestController
@RequestMapping(value = "/health")
public class HealthRest {
    @RequestMapping("/index")
    public String index(){
        return "hello spring boot";
    }
}
