package com.hofey.dwy.server.exception;

import com.hofey.dwy.server.vo.ResultCode;

/**
 * @Author: hofey
 * @Date: 2020/1/9 14:10
 * @Description: 业务异常类
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 194906846739586856L;

    protected String code;

    protected String message;

    protected ResultCode resultCode;

    protected Object data;


}
