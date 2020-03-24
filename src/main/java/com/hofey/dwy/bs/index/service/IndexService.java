package com.hofey.dwy.bs.index.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: hofey
 * @Date: 2020/2/11 15:14
 * @Description:
 */
@Validated
public interface IndexService {
    void printHello(@NotEmpty String param1);
}
