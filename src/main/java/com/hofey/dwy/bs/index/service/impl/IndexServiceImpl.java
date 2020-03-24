package com.hofey.dwy.bs.index.service.impl;

import com.hofey.dwy.bs.index.service.IndexService;
import com.hofey.dwy.server.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author: hofey
 * @Date: 2020/2/11 15:14
 * @Description:
 */

@Service

public class IndexServiceImpl implements IndexService {
    @Override
    public void printHello(String param1) {
        int i = 1/0;
            throw new BusinessException();
    }
}
