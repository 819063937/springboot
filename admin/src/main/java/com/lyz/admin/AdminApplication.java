package com.lyz.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/3 23:39
 */
@SpringBootApplication
@MapperScan({"com.lyz.admin.mapper"})
public class AdminApplication {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(AdminApplication.class, args);
        System.out.println("*******************************#########################*******************************");
        System.out.println("AdminApplication start success use " + (System.currentTimeMillis() - start) / 1000);
    }
}