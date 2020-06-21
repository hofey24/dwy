package com.hofey.dwy.demo.plugins.mapstruct;

import lombok.Data;

import java.util.Date;

/**
 * @program: dwy
 * @description: DO  在阿里云java开发规则中称之为Data Object ,其和数据库表映射且字段一一对应
 * 在 ORM(Object relation Mapping)
 * ORM的实现思想：
 * 将关系数据库中表中的记录映射成为对象，以对象的形式展现，程序员可以把对数据库的操作转化为对对象的操作
 * 因为
 * 用户信息
 * @author: yhf
 * @create: 2020-06-21 10:05
 **/
@Data
public class User {
    private Integer id;
    private String realName;
    private Integer age;
    private String mobile;
    private Date createTime;
}
