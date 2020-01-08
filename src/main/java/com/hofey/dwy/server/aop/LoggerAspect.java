package com.hofey.dwy.server.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hofey
 * @Title: 方法运行时间统计
 * @Package
 * @Description: 统计方法运行时间
 * @date 2019/3/1210:53
 */
@Slf4j
@Aspect//定义切面
@Component
public class LoggerAspect {
    //定义切点
    /**
     *1、execution(): 表达式主体。
     2、第一个*号：表示返回类型，*号表示所有的类型。
     3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     4、第二个*号：表示类名，*号表示所有的类。
     5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
    */
    @Around("execution(public * com.hofey.dwy..*Controller.*(..))")
    public Object LoggerAround(ProceedingJoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("【ip地址】->{}",getRemortIP(request));
        Object[] args = joinPoint.getArgs();
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        log.info(" 【{}】 ## request param # {}",joinPoint.getSignature().getName(), JSONObject.toJSONString(arguments));
        Object resResult = null;
        try {
            resResult = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(" 【{}】## response error # {}",joinPoint.getSignature().getName(),throwable.toString());
           /* throw new MlkException(throwable.getMessage());*/
        }
        log.info(" 【{}】 ## response result # {}",joinPoint.getSignature().getName(),JSONObject.toJSONString(resResult));
        return resResult;
    }

    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
