package com.lyz.admin.enums;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 14:52
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS("200", "成功"),
    /**
     * 失败
     */
    ERROR("500", "服务器内部错误");

    private String code;

    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
