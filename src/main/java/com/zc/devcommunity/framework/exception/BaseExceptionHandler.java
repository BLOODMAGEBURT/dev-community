package com.zc.devcommunity.framework.exception;


import com.zc.devcommunity.entity.Result;
import com.zc.devcommunity.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {
    /***
     * 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {

        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
