package com.lyz.admin.exception;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 14:03
 */
public class CommonException extends Exception {

    private String code;

    private String message;

    public CommonException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
