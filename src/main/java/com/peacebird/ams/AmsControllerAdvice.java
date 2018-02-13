package com.peacebird.ams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor kevin.dai
 * @Date 2018/2/12
 */


@ControllerAdvice
public class AmsControllerAdvice {

    private Logger logger  = LoggerFactory.getLogger(getClass());


    /**
     * 全局异常处理 /error
     * @Date: 09:32 2018/2/12
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody  String errorExceptionHandler(Exception e){
        logger.info("=============全局异常处理开始============");
        return e.getMessage();
    }


    
    /**
     * 无权访问统一返回视图
     * @Date: 10:07 2018/2/12
     */
    @ExceptionHandler(AuthorizationServiceException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String processUnauthenticatedException(){
        logger.info("=============授权异常处理开始============");
        return  "sb";
    }







}
