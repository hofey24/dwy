package com.hofey.dwy.demo.plugins.mapstruct;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * @program: dwy
 * @description: UserDO and DTO transfer Mapper
 * @author: yhf
 * @create: 2020-06-21 16:38
 **/
@Component
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);
    @BeanMapping(nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
