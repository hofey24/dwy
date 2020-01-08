package com.hofey.dwy.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hofey
 * @Date: 2020/1/6 16:06
 * @Description:
 */
@RestController
public class HealthRest {
    private final  Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    public String index(){
        logger.info("-------------");
        logger.info("-------health------");
        logger.info("-------------");
        return "hello spring boot";
    }
}
