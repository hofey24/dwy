package com.hofey.dwy.server.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: hofey
 * @Date: 2020/1/9 15:52
 * @Description: API 返回值 封装类
 */
@Data
public class Result implements Serializable {
    private Integer code;
    private String  msg;
    private Object  data;


    public static Result  ok(){
        return new Result().setResultCode(ResultCode.SUCCESS);
    }
    //设置消息
    public Result msg(String msg){
        this.setMsg(msg);
        return this;
    }//设置返回对象
    public Result putData(Object data){
        this.setData(data);
        return this;
    }



    public static Result FAIL(){
        return new Result().setResultCode(ResultCode.FAIL);
    }
    public static Result FAIL(ResultCode resultCode){
        return new Result().setResultCode(resultCode);
    }
    public static Result FAIL(ResultCode resultCode,Object data){
        return new Result().setResultCode(resultCode).putData(data);
    }


    /*设置枚举状态码最为返回值*/
    private Result setResultCode(ResultCode resultCode){
        this.code=resultCode.code();
        this.msg =resultCode.message();
        return this;
    }

}
