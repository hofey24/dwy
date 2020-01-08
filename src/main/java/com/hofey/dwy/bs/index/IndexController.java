package com.hofey.dwy.bs.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hofey
 * @Date: 2020/1/8 17:46
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/v1")
public class IndexController {
    @GetMapping(value = "/index")
    public String index(){
        return "index controller";
    }
}
