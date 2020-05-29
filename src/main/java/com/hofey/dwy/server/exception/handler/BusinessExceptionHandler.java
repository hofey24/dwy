package com.hofey.dwy.server.exception.handler;

import com.hofey.dwy.server.exception.BusinessException;
import com.hofey.dwy.server.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * @Author: hofey
 * @Date: 2020/2/11 09:57
 * @Description: 异常处理类
 */
@ControllerAdvice
public class BusinessExceptionHandler {


    /***
     * 自定义业务异常
     * @param e
     * @return
     */
    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //自定义浏览器返回状态码*/
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result exceptionHandler(BusinessException e) {
        e.printStackTrace();
        return Result.fail().msg(e.getErrorMsg());
    }

    /***
     * 校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = { ConstraintViolationException.class})
    @ResponseBody
    public Result validationException(ConstraintViolationException e){
        e.printStackTrace();
        return Result.fail().msg("数据校验失败");
    }
    /***
     * 算术异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public Result arithmeticException(ArithmeticException e){
        e.printStackTrace();
        return Result.fail().msg("算术异常");
    }
    /***
     * 所有异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result programException(Exception e){
        e.printStackTrace();
        return Result.fail().msg("程序异常");
    }
}
