package com.hofey.dwy.demo.plugins.mapstruct;


import lombok.Data;

/**
 * @program: dwy
 * @description:
 * DTO 数据转换对象
 * @author: yhf
 * @create: 2020-06-21 10:06
 **/
@Data
public class UserDTO {
    private Integer id;
    private String realName;
    private Integer age;
    private String mobile;
}
