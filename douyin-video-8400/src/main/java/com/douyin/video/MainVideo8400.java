package com.douyin.video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;

/**
 * @author castall
 * @date 2023/7/16 15:09
 */
@SpringBootApplication
@MapperScan("com.douyin.video.mapper")
public class MainVideo8400 {

    public static void main(String[] args){
//        SpringApplication.run(MainVideo8400.class,args);
//        // 打印系统时区位置
//        System.out.println("Video time zone");
//        System.out.println(ZoneId.systemDefault());

        int k = 10;
        k = k+(++k);
        System.out.println(k);
    }

    public void test1(){
    }

    public void test2(){

    }

}
