package com.lyz.admin.handler;

import java.util.Map;
import java.util.Objects;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.lyz.admin.dto.RestResult;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 14:16
 */
@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
        Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        if (body instanceof String || body == null) {
            return RestResult.success(body);
        }
        if (body instanceof RestResult) {
            return body;
        }
        if (body instanceof Map) {
            Map<String, Object> map = (Map)body;
            if (Objects.equals(HttpStatus.NOT_FOUND.value(), map.get("status"))) {
                return new RestResult(HttpStatus.NOT_FOUND.value() + "", "请求地址不存在", body);
            }
        }
        return RestResult.success(body);
    }
}
