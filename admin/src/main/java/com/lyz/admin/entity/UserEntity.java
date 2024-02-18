package com.lyz.admin.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表实体类
 *
 * @author lyz
 * @date 2024-02-03 23:37:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户中文姓名
     */
    private String username;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 性别0男，1女，2未知
     */
    private Integer gender;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String mailAddress;

    /**
     * 头像地址
     */
    private String headAddress;

    /**
     * 是否启用，0启用，1不启用
     */
    private Integer status;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 密码修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date passwordTime;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 是否删除，1删除，0为删除
     */
    private Integer deleteFlg;

    /**
     * 创建用户名
     */
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新用户名
     */
    private String updateUser;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}