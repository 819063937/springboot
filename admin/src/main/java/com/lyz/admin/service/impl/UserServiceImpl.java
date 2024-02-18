package com.lyz.admin.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lyz.admin.entity.UserEntity;
import com.lyz.admin.mapper.UserMapper;
import com.lyz.admin.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户表接口实现
 *
 * @author lyz
 * @date 2024-02-03 23:37:18
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Qualifier("commonExecutorService")
    @Autowired
    private ExecutorService executorService;

    @Override
    public Integer queryUserCount(Map<String, Object> map) {
        return userMapper.queryUserCount(map);
    }

    @Override
    public List<UserEntity> queryUserList(Map<String, Object> map) {
        return userMapper.queryUserList(map);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(UserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchInsertUser(List<UserEntity> userEntitys) {
        return userMapper.batchInsertUser(userEntitys);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(UserEntity userEntity) {
        return userMapper.updateUser(userEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(Set<Long> ids) {
        return userMapper.deleteUser(ids, null, null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importExcel(MultipartFile file) {
        return null;
    }

    @Override
    public void exportExcel(HttpServletResponse response, Map<String, Object> map) {

    }
}