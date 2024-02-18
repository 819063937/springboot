package com.lyz.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.lyz.admin.entity.UserEntity;

/**
 * 用户表接口
 *
 * @author lyz
 * @date 2024-02-03 23:37:18
 */
public interface UserService {
    /**
     * 用户表查询数量
     *
     * @param map 具体的参数map
     * @return Integer
     */
    Integer queryUserCount(Map<String, Object> map);

    /**
     * 用户表查询集合
     *
     * @param map 具体的参数map
     * @return List
     */
    List<UserEntity> queryUserList(Map<String, Object> map);

    /**
     * 根据主键查询用户表信息
     *
     * @param id 主键
     * @return int
     */
    UserEntity getUserById(Long id);

    /**
     * 用户表新增操作
     *
     * @param userEntity 用户表数据
     * @return int
     */
    int insertUser(UserEntity userEntity);

    /**
     * 用户表批量新增操作
     *
     * @param userEntitys 用户表数据集合
     * @return int
     */
    int batchInsertUser(List<UserEntity> userEntitys);

    /**
     * 用户表更新操作
     *
     * @param userEntity 用户表数据
     * @return int
     */
    int updateUser(UserEntity userEntity);

    /**
     * 用户表逻辑 删除操作
     *
     * @param ids 主键set集合
     * @return int
     */
    int deleteUser(Set<Long> ids);

    /**
     * 用户表导入操作
     *
     * @param file
     * @return String
     */
    String importExcel(MultipartFile file);

    /**
     * 用户表导出操作
     *
     * @param response response
     * @param map map
     */
    void exportExcel(HttpServletResponse response, Map<String, Object> map);
}