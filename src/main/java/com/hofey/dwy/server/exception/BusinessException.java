package com.hofey.dwy.server.exception;


import com.hofey.dwy.server.vo.ResultCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hofey
 * @Date: 2020/1/9 14:10
 * @Description: 业务异常
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private Integer errorNo;
    private String errorMsg;

    /***
     * 初始化业务异常信息(使用默认错误返回枚举值)
     */
    public BusinessException() {
        this.errorNo = ResultCode.FAIL.code();
        this.errorMsg = ResultCode.FAIL.message();
    }

    /***
     * 初始化业务异常信息(自定义异常信息)
     * @param errorMsg
     */
    public BusinessException(String errorMsg) {
        this.errorNo = ResultCode.FAIL.code();
        this.errorMsg = errorMsg;
    }

    /***
     * 初始化业务异常信息(使用参数:结果返回枚举值)
     * @param resultCode
     */
    public BusinessException(ResultCode resultCode) {
        this.errorNo = resultCode.code();
        this.errorMsg = resultCode.message();
    }

    /***
     *初始化业务异常信息(使用参数:结果返回枚举值 和 自定义错误信息)
     * @param resultCode
     * @param errorMsg
     */
    public BusinessException(ResultCode resultCode, String errorMsg) {
        this.errorNo = resultCode.code();
        this.errorMsg = errorMsg;
    }

    /***
     * 初始化业务异常信息
     * 自定义 错误 code 码 及 错误信息
     * @param errorNo
     * @param errorMsg
     */
    public BusinessException(int errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

}
