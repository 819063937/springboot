package com.lyz.admin.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lyz.admin.entity.UserEntity;

/**
 * 用户表mapper
 *
 * @author lyz
 * @date 2024-02-03 23:37:18
 */
@Repository
public interface UserMapper {
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
    UserEntity getUserById(@Param("id") Long id);

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
    int batchInsertUser(@Param("userEntitys") List<UserEntity> userEntitys);

    /**
     * 用户表更新操作
     *
     * @param userEntity 用户表数据
     * @return int
     */
    int updateUser(UserEntity userEntity);

    /**
     * 用户表逻辑删除操作
     *
     * @param ids 主键set集合
     * @param updateUser 更新用户名
     * @param updateTime 更新时间
     * @return int
     */
    int deleteUser(@Param("ids") Set<Long> ids, @Param("updateUser") String updateUser,
        @Param("updateTime") Date updateTime);
}
