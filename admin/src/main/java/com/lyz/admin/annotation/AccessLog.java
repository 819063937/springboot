package com.lyz.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 13:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLog {
    /**
     * 操作名称
     * 
     * @return String
     */
    String name();

    /**
     * 操作名称
     * 
     * @return String
     */
    String type() default "";

    /**
     * 操作名称
     * 
     * @return String
     */
    String desc() default "";
}
