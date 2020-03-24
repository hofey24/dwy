package com.hofey.dwy.server.exception.handler;

import com.hofey.dwy.server.exception.BusinessException;
import com.hofey.dwy.server.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;

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
    public Result ExceptionHandler(BusinessException e) {
        e.printStackTrace();
        return Result.FAIL().msg(e.getErrorMsg());
    }

    /***
     * 校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = { ConstraintViolationException.class})
    @ResponseBody
    public Result ValidationException(ConstraintViolationException e){
        e.printStackTrace();
        return Result.FAIL().msg("数据校验失败");
    }
    /***
     * 算术异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public Result ArithmeticException(ArithmeticException e){
        e.printStackTrace();
        return Result.FAIL().msg("算术异常");
    }
    /***
     * 所有异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ArithmeticException(Exception e){
        e.printStackTrace();
        return Result.FAIL().msg("程序异常");
    }
}
