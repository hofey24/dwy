package com.hofey.dwy.bs.index;

import com.hofey.dwy.bs.index.service.IndexService;
import com.hofey.dwy.server.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IndexService indexService;
    @GetMapping(value = "/index")
    public String index() {
        return "index controller";
    }

    @GetMapping(value = "/result")
    public ResponseResult result() {
        return ResponseResult.ok().msg("返回消息成功").putData("data");
    }

    @GetMapping(value = "/error")
    public ResponseResult error() {
        indexService.printHello("");
        return ResponseResult.ok();
    }
}
