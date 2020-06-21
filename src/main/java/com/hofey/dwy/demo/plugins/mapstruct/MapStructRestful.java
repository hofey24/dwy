package com.hofey.dwy.demo.plugins.mapstruct;

import com.hofey.dwy.server.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: dwy
 * @description:
 * mapstruct  dto和do 之间的转换映射
 * @author: yhf
 * @create: 2020-06-21 10:03
 **/
@RestController
@RequestMapping("/mapstruct")
public class MapStructRestful {
    @PostMapping("/savaUser")
    public Result saveUser(@RequestBody UserDTO userDTO){
        System.out.println("----------");
        User user = new User();
        user.setAge(18);
        user = UserMapper.INSTANCE.toUser(userDTO);
        System.out.println(user.toString());
        User user1 = new User();
        user1.setAge(18);
        user1.setId(1);
        user1.setMobile("13716202033");
        user1.setCreateTime(new Date());
        UserMapper.INSTANCE.updateUserFromDTO(userDTO,user1);
        System.out.println("user1 :"+user1.toString());
        return Result.ok();
    }
}
