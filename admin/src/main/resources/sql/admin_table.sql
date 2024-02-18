/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80036
Source Host           : localhost:3306
Source Database       : zyzt

Target Server Type    : MYSQL
Target Server Version : 80036
File Encoding         : 65001

Date: 2024-02-03 23:54:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_account` varchar(50) NOT NULL COMMENT '账号',
  `username` varchar(50) NOT NULL COMMENT '用户中文姓名',
  `user_password` varchar(50) NOT NULL COMMENT '密码',
  `gender` tinyint(1) NOT NULL DEFAULT '2' COMMENT '性别0男，1女，2未知',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `mail_address` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `head_address` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用，0启用，1不启用',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `password_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '密码修改时间',
  `dept_id` bigint DEFAULT NULL COMMENT '部门id',
  `delete_flg` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，1删除，0为删除',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建用户名',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新用户名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_account_index` (`user_account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户表';
