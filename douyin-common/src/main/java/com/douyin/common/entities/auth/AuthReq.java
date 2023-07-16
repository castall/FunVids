package com.douyin.common.entities.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Gary
 * @create 2023-07-16 13:02
 */
@Data
public class AuthReq implements Serializable {
    private String username;
    private String password;
    private Integer userId;
    private String token;
}
