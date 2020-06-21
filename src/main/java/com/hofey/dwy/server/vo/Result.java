package com.hofey.dwy.server.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: hofey
 * @Date: 2020/1/9 15:52
 * @Description: API 返回值 封装类
 */

public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok() {
        return new Result().setResultCode(ResultCode.SUCCESS);
    }

    //设置消息
    public Result code(int code) {
        this.code(code);
        return this;
    }

    //设置消息
    public Result msg(String msg) {
        this.setMsg(msg);
        return this;
    }//设置返回对象

    public Result putData(Object data) {
        this.setData(data);
        return this;
    }


    public static Result fail() {
        return new Result().setResultCode(ResultCode.FAIL);
    }

    public static Result fail(ResultCode resultCode) {
        return new Result().setResultCode(resultCode);
    }

    public static Result fail(ResultCode resultCode, Object data) {
        return new Result().setResultCode(resultCode).putData(data);
    }


    /*设置枚举状态码最为返回值*/
    private Result setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.message();
        return this;
    }

}
