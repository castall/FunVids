package com.douyin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Gary
 * @create 2023-07-16 11:27
 */
@SpringBootApplication
@MapperScan("com.douyin.auth.mapper")
@EnableDiscoveryClient
public class MainAuth8200 {
    public static void main(String[] args) {
        SpringApplication.run(MainAuth8200.class,args);
        /**
         * 先校验登录状态，video服务rpc 调用auth --> status
         *
         * 上传到mino成功之后，videoNum+1 --> 消息队列  用户videoNum+1
         *
         * user模块监听队列   用户 videoNum + 1 --> 消费
         *
         *
         */
    }
}
