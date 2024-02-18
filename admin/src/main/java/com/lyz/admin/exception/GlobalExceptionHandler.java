package com.lyz.admin.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lyz.admin.dto.RestResult;
import com.lyz.admin.enums.ResultEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 10:42
 */
@ResponseBody
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult handlerException(CommonException e) {
        printStackTrace(e.getStackTrace());
        return new RestResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult handlerException(Exception e, HttpServletRequest request) {
        log.error(" Exception 异常 {}", request.getRequestURI(), e);
        return new RestResult(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult handlerException(Throwable e, HttpServletRequest request) {
        log.error(" Throwable 异常 {}", request.getRequestURI(), e);
        return new RestResult(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage());
    }

    private void printStackTrace(StackTraceElement[] elements) {
        StringBuffer sb = new StringBuffer();
        for (StackTraceElement element : elements) {
            sb.append(element + " end:");
        }
        log.error(sb.toString());
    }
}
