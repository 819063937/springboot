package com.lyz.admin.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lyz.admin.entity.UserEntity;
import com.lyz.admin.service.UserService;

/**
 * 用户表控制层
 *
 * @author lyz
 * @date 2024-02-03 23:37:18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户表查询(分页可选)
     *
     * @param map 参数
     * @return List
     */
    @PostMapping("/query")
    public List<UserEntity> queryUserList(@RequestBody Map<String, Object> map) {
        return userService.queryUserList(map);
    }

    /**
     * 根据主键查询用户表信息
     *
     * @param id 主键
     * @return int
     */
    @GetMapping("/detail/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * 用户表新增操作
     *
     * @param userEntity 用户表数据
     * @return int
     */
    @PostMapping("/save")
    public int insertUser(@RequestBody UserEntity userEntity) {
        return userService.insertUser(userEntity);
    }

    /**
     * 用户表批量新增操作
     *
     * @param userEntitys 用户表数据集合
     * @return int
     */
    @PostMapping("/batchSave")
    public int batchInsertUser(@RequestBody List<UserEntity> userEntitys) {
        return userService.batchInsertUser(userEntitys);
    }

    /**
     * 用户表更新操作
     *
     * @param userEntity 用户表数据
     * @return int
     */
    @PostMapping("/update")
    public int updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    /**
     * 用户表逻辑 删除操作
     *
     * @param ids 主键set集合
     * @return int
     */
    @DeleteMapping("/delete/{ids}")
    public int deleteUser(@PathVariable("ids") Set<Long> ids) {
        return userService.deleteUser(ids);
    }

    /**
     * 用户表导入操作
     *
     * @param file
     * @return String
     */
    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String importExcel(@RequestPart("file") MultipartFile file) {
        return userService.importExcel(file);
    }

    /**
     * 用户表导出操作
     *
     * @param response response
     * @param map map
     */
    @PostMapping("/export")
    public void exportExcel(HttpServletResponse response, @RequestBody Map<String, Object> map) {
        userService.exportExcel(response, map);
    }
}
