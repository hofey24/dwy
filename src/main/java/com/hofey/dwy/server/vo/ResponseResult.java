package com.hofey.dwy.server.vo;

import java.io.Serializable;

/**
 * @Author: hofey
 * @Date: 2020/1/9 15:52
 * @Description: API 返回值 封装类
 */

public class ResponseResult implements Serializable {
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

    public static ResponseResult ok() {
        return new ResponseResult().setResultCode(ResultCode.SUCCESS);
    }

    //设置消息
    public ResponseResult code(int code) {
        this.code(code);
        return this;
    }

    //设置消息
    public ResponseResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }//设置返回对象

    public ResponseResult putData(Object data) {
        this.setData(data);
        return this;
    }


    public static ResponseResult fail() {
        return new ResponseResult().setResultCode(ResultCode.FAIL);
    }

    public static ResponseResult fail(ResultCode resultCode) {
        return new ResponseResult().setResultCode(resultCode);
    }

    public static ResponseResult fail(ResultCode resultCode, Object data) {
        return new ResponseResult().setResultCode(resultCode).putData(data);
    }


    /*设置枚举状态码最为返回值*/
    private ResponseResult setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.message();
        return this;
    }

}
