package com.lyz.admin.dto;

import java.io.Serializable;

import com.lyz.admin.enums.ResultEnum;

import lombok.Data;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 13:42
 */
@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = -1713566465225795140L;

    private String code;

    private String message;

    private T data;

    public RestResult() {

    }

    public RestResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

}
